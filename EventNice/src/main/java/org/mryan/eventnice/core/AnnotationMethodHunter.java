package org.mryan.eventnice.core;

import org.mryan.eventnice.exception.EventException;
import org.mryan.eventnice.utils.MethodHelper;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description： method捕猎者
 * @Author MRyan
 * @Date 2021/10/9 17:57
 */
public class AnnotationMethodHunter extends Hunter {

    /**
     * 捕获指定的class里面使用了Annotation注解的方法
     *
     * @param clazz
     * @return
     */
    @Override
    public Map<Class<?>, Set<Method>> huntingMethods(Class<?> clazz) {
        Map<Class<?>, Set<Method>> methodMap = new HashMap<>();
        //一级缓存（方发表缓存)
        synchronized (super.methodCache) {
            if (super.methodCache.containsKey(clazz)) {
                methodMap = super.methodCache.get(clazz);
            }
        }
        if (methodMap.isEmpty()) {
            while (!MethodHelper.shouldSkipClass(clazz)) {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    if (MethodHelper.isConditionMethod(method)) continue;
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        throw new EventException(String.format(
                                "Method %s has @EventReceive annotation but has %s parameters." + "Subscriber methods must have exactly 1 parameter.",
                                method, parameterTypes.length));
                    }
                    Class<?> parameterType = parameterTypes[0];
                    if (!methodMap.containsKey(parameterType)) {
                        methodMap.put(parameterType, new HashSet<>());
                    }
                    methodMap.get(parameterType).add(method);
                }
                //递归查找父类 支持hierarchy
                clazz = clazz.getSuperclass();
            }
            super.methodCache.put(clazz, methodMap);
        }
        return methodMap;
    }


    /**
     * 捕获指定匹配事件接收器
     *
     * @param registry 事件接收器注册中心
     * @param event
     * @return
     */
    @Override
    public CopyOnWriteArraySet<EventReceiver> huntingMatchedEventReceivers(ReceiverRegistry registry, Object event) {
        Class<?> postedEventType = event.getClass();
        return registry.getRegistry().get(postedEventType);
    }

    /**
     * 捕获当前EventReceive所有事件接收器
     *
     * @param receiver
     * @return
     */
    @Override
    public Map<Class<?>, Collection<EventReceiver>> huntingAllEventReceiver(Object receiver) {
        Map<Class<?>, Collection<EventReceiver>> receivers = new HashMap<>();
        Class<?> clazz = receiver.getClass();
        synchronized (super.eventReceiverCache) {
            if (eventReceiverCache.containsKey(clazz)) {
                receivers = eventReceiverCache.get(clazz);
            }
        }
        if (receivers.isEmpty()) {
            Map<Class<?>, Set<Method>> paramMethodMap = this.huntingMethods(clazz);
            //处理Event多继承实现
            for (Class<?> paramClass : paramMethodMap.keySet()) {
                Class<?> targetClazz = paramClass;
                while (!MethodHelper.shouldSkipClass(targetClazz)) {
                    Set<Method> methods = paramMethodMap.get(targetClazz);
                    if (methods == null) {
                        continue;
                    }
                    for (Method method : methods) {
                        if (!receivers.containsKey(paramClass)) {
                            receivers.put(paramClass, new ArrayList<>());
                        }
                        receivers.get(paramClass).add(new EventReceiver(new MethodInfo(method, targetClazz), receiver));
                    }
                    //逐级遍历Event的父类
                    targetClazz = targetClazz.getSuperclass();
                }
            }
            eventReceiverCache.put(clazz, receivers);
        }
        return receivers;
    }

}

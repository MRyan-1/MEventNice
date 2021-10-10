package org.mryan.eventnice.core;

import org.mryan.eventnice.annotation.EventReceive;
import org.mryan.eventnice.exception.EventException;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description： method捕猎者
 * @Author MRyan
 * @Date 2021/10/9 17:57
 */
public class AnnotationMethodHunter implements Hunter {


    /**
     * 捕获指定的class里面使用了Annotation注解的方法
     *
     * @param clazz
     * @return
     */
    @Override
    public Set<Method> huntingMethods(Class<?> clazz) {
        Set<Method> annotatedMethods = new HashSet<>();
        while (!shouldSkipClass(clazz)) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                //过滤非@EventReceive注解标识方法
                if (!method.isAnnotationPresent(EventReceive.class)) {
                    continue;
                }
                //过滤非public方法
                if (!Modifier.isPublic(method.getModifiers())) {
                    continue;
                }
                //过滤volatile方法，修复Java编译器自动添加bridge方法造成的方法重复的问题
                if (Modifier.isVolatile(method.getModifiers())) {
                    continue;
                }
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new EventException(String.format(
                            "Method %s has @EventReceive annotation but has %s parameters." + "Subscriber methods must have exactly 1 parameter.",
                            method, parameterTypes.length));
                }
                annotatedMethods.add(method);
            }
            //递归查找父类 支持hierarchy
            clazz = clazz.getSuperclass();
        }
        return annotatedMethods;
    }

    /**
     * 过滤条件，大幅提高父类查找的效率，减少不必要的遍历
     *
     * @param clazz
     * @return
     */
    private boolean shouldSkipClass(final Class<?> clazz) {
        final String clsName = clazz.getName();
        return Object.class.equals(clazz)
                || clsName.startsWith("java.")
                || clsName.startsWith("javax.");
    }

    /**
     * 捕获指定匹配事件接收器
     *
     * @param registry 事件接收器注册中心
     * @param event
     * @return
     */
    @Override
    public List<EventReceiver> huntingMatchedEventReceivers(ReceiverRegistry registry, Object event) {
        List<EventReceiver> matchReceivers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<EventReceiver>> entry : registry.getRegistry().entrySet()) {
            Class<?> eventType = entry.getKey();
            CopyOnWriteArraySet<EventReceiver> eventReceivers = entry.getValue();
            if (postedEventType.isAssignableFrom(eventType)) {
                matchReceivers.addAll(eventReceivers);
            }
        }
        return matchReceivers;
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
        Set<Method> methods = this.huntingMethods(clazz);
        for (Method method : methods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!receivers.containsKey(eventType)) {
                receivers.put(eventType, new ArrayList<>());
            }
            receivers.get(eventType).add(new EventReceiver(new MethodInfo(method, receiver.getClass()), receiver));
        }
        return receivers;
    }

}

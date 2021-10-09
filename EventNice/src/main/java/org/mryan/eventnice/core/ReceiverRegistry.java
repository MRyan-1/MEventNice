package org.mryan.eventnice.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description： 事件接收器注册中心
 * @Author MRyan
 * @Date 2021/10/8 23:38
 * @Version 1.0
 */
public class ReceiverRegistry implements Registry {


    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<EventReceiver>> registry = new ConcurrentHashMap<>();

    /**
     * method捕猎者
     */
    private final MethodHunter methodHunter;

    public ReceiverRegistry() {
        this.methodHunter = new AnnotationMethodHunter();
    }


    /**
     * register event target
     * 注册事件接收器的目标对象
     * 保证后续调度时 可以触发该事件接收器定义的事件
     *
     * @param receiver
     * @return
     */
    @Override
    public boolean register(Object receiver) {
        Map<Class<?>, Collection<EventReceiver>> receivers = findAllEventReceiver(receiver);
        for (Map.Entry<Class<?>, Collection<EventReceiver>> entry : receivers.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<EventReceiver> eventReceivers = entry.getValue();
            CopyOnWriteArraySet<EventReceiver> registeredEventReceivers = registry.get(eventType);
            if (registeredEventReceivers == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registeredEventReceivers = registry.get(eventType);
            }
            registeredEventReceivers.addAll(eventReceivers);
        }
        return true;
    }

    /**
     * 注销已注册的事件接受器
     * 保证后续调度时，不在触发该事件接收器定义的事件
     *
     * @param receiver
     * @return
     */
    @Override
    public boolean unregister(Object receiver) {
        //todo unregister
        return false;
    }


    private Map<Class<?>, Collection<EventReceiver>> findAllEventReceiver(Object receiver) {
        Map<Class<?>, Collection<EventReceiver>> receivers = new HashMap<>();
        Class<?> clazz = receiver.getClass();
        Set<Method> methods = methodHunter.huntingMethods(clazz);
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

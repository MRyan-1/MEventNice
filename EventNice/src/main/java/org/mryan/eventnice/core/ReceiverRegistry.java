package org.mryan.eventnice.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;
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
    private final Hunter methodHunter;

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
        Map<Class<?>, Collection<EventReceiver>> receivers = huntingAllEventReceiver(receiver);
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
        Map<Class<?>, Collection<EventReceiver>> receivers = huntingAllEventReceiver(receiver);
        for (Map.Entry<Class<?>, Collection<EventReceiver>> entry : receivers.entrySet()) {
            Class<?> eventType = entry.getKey();
            if (registry.get(eventType) == null) {
                throw new IllegalArgumentException(
                        "missing event subscriber for an annotated method. Is " + receiver + " registered?");
            }
            registry.remove(eventType);
        }
        return true;
    }


    /**
     * 捕获当前EventReceive所有事件接收器
     *
     * @param receiver
     * @return
     */
    private Map<Class<?>, Collection<EventReceiver>> huntingAllEventReceiver(Object receiver) {
        return methodHunter.huntingAllEventReceiver(receiver);
    }

    /**
     * 捕获指定匹配事件接收器
     *
     * @param event
     * @return
     */
    public  CopyOnWriteArraySet<EventReceiver> huntingMatchedEventReceivers(Object event) {
        return methodHunter.huntingMatchedEventReceivers(this, event);
    }

    public ConcurrentMap<Class<?>, CopyOnWriteArraySet<EventReceiver>> getRegistry() {
        return registry;
    }
}

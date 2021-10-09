package org.mryan.eventnice.core;

import java.lang.reflect.InvocationTargetException;

/**
 * @description： 事件总线上下文
 * @Author MRyan
 * @Date 2021/10/8 23:37
 * @Version 1.0
 */
public class EventContext {

    /**
     * 事件调度器
     */
    private final EventDispatcher dispatcher;

    /**
     * 事件接收器注册中心
     */
    private final ReceiverRegistry registry;

    /**
     * 标识
     */
    private final String identifier;


    public EventContext() {
        this("default");
    }

    public EventContext(String identifier) {
        this(identifier,
                EventDispatcher.perDefaultEventDispatcher(),
                new ReceiverRegistry()
        );
    }


    public EventContext(String identifier, EventDispatcher dispatcher, ReceiverRegistry registry) {
        this.identifier = identifier;
        this.dispatcher = dispatcher;
        this.registry = registry;
    }

    /**
     * 事件调度，向所有已注册的事件接收方发送消息通知
     *
     * @param event
     */
    public void post(Object event) {
        dispatcher.post(event);
    }

    /**
     * register event target
     * 注册事件接收器的目标对象
     * 保证后续调度时 可以触发该事件接收器定义的事件
     *
     * @param listener
     */
    public void register(Object listener) {
        registry.register(listener);
    }

    /**
     * 注销已注册的事件接受器
     * 保证后续调度时，不在触发该事件接收器定义的事件
     *
     * @param listener
     */
    public void unregister(Object listener) {
        registry.unregister(listener);
    }

    public String getIdentifier() {
        return identifier;
    }

}

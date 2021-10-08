package org.mryan.eventnice.core;

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
    private EventDispatcher dispatcher;

    /**
     * 事件接收器注册中心
     */
    private ReceiverRegistry registry;

    /**
     * 标识
     */
    private String identifier;

    public EventContext() {
        this("default");
    }

    public EventContext(String identifier) {
        this(identifier, EventDispatcher.perDefaultEventDispatcher(), new ReceiverRegistry());
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
     * 注册所有事件接收方 以接受事件
     *
     * @param listener
     */
    public void register(Object listener) {
        registry.register(listener);
    }

    /**
     * 注销已注册的事件接受方
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

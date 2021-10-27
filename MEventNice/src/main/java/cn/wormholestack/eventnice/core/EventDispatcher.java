package cn.wormholestack.eventnice.core;

import java.util.concurrent.Executor;

/**
 * @description： 事件调度器
 * @Author MRyan
 * @Date 2021/10/8 23:49
 * @Version 1.0
 */
public abstract class EventDispatcher {

    /**
     * Posts an event to all registered subscribers
     * 为调用注册当前事件的接收器方法 发送事件
     *
     * @param target
     */
    public abstract void post(Object target, ReceiverRegistry registry);

    /**
     * 生成默认的事件调度器
     *
     * @return
     */
    static EventDispatcher perDefaultEventDispatcher(Executor executor) {
        return new DefaultEventDispatcher(executor);
    }
}

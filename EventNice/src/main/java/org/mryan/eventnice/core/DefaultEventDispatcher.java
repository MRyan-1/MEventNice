package org.mryan.eventnice.core;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @description： 默认事件调度器
 * @Author MRyan
 * @Date 2021/10/9 00:46
 * @Version 1.0
 */
public class DefaultEventDispatcher extends EventDispatcher {

    /**
     * 执行器
     */
    private Executor executor;

    public DefaultEventDispatcher(Executor executor) {
        this.executor = executor;
    }

    /**
     * 事件调度
     *
     * @param event
     * @param registry
     */
    @Override
    public void post(Object event, ReceiverRegistry registry) {
        List<EventReceiver> eventReceivers = registry.huntingMatchedEventReceivers(event);
        for (EventReceiver eventReceiver : eventReceivers) {
            executor.execute(() -> {
                try {
                    eventReceiver.invoke(event);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}

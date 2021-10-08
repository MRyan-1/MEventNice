package org.mryan.eventnice.core;

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

    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<EventReceiver>> eventReceivers = new ConcurrentHashMap<>();


    public ReceiverRegistry() {
    }

    @Override
    public boolean register(Object target) {
        //todo register
        return false;
    }

    @Override
    public boolean unregister(Object target) {
        //todo unregister
        return false;
    }

}

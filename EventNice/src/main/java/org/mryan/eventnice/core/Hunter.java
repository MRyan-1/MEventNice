package org.mryan.eventnice.core;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @description： 捕猎者
 * @Author MRyan
 * @Date 2021/10/8 23:59
 * @Version 1.0
 */
public abstract class Hunter {

    /**
     * 方法表缓存
     */
    final Map<Class<?>, Map<Class<?>, Set<Method>>> methodCache = new ConcurrentHashMap<>();

    /**
     * 捕获指定方法
     *
     * @param clazz
     * @return
     */
    abstract Map<Class<?>, Set<Method>> huntingMethods(Class<?> clazz);

    /**
     * 捕获指定匹配事件接收器
     *
     * @param registry 事件接收器注册中心
     * @param event
     * @return
     */
    abstract CopyOnWriteArraySet<EventReceiver> huntingMatchedEventReceivers(ReceiverRegistry registry, Object event);

    /**
     * 捕获当前EventReceive所有事件接收器
     *
     * @param receiver
     * @return
     */
    abstract Map<Class<?>, Collection<EventReceiver>> huntingAllEventReceiver(Object receiver);

}

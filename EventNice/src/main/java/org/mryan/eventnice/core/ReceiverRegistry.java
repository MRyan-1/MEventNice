package org.mryan.eventnice.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
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

    /**
     * method捕猎者
     */
    private MethodHunter methodHunter;

    public ReceiverRegistry() {
    }


    /**
     * register event target
     * 注册事件接收器的目标对象
     * 保证后续调度时 可以触发该事件接收器定义的事件
     *
     * @param target
     * @return
     */
    @Override
    public boolean register(Object target) {
        //todo register
        return false;
    }

    /**
     * 注销已注册的事件接受器
     * 保证后续调度时，不在触发该事件接收器定义的事件
     *
     * @param target
     * @return
     */
    @Override
    public boolean unregister(Object target) {
        //todo unregister
        return false;
    }


    private Set<MethodInfo> getMethods(Class<?> targetClass) {
        return methodHunter.huntingMethods(this, targetClass);
    }

}

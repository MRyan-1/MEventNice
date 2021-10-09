package org.mryan.eventnice.core;

import java.lang.reflect.InvocationTargetException;

/**
 * @description： 注册中心
 * @Author MRyan
 * @Date 2021/10/8 23:45
 * @Version 1.0
 */
public interface Registry {

    /**
     * register event target
     * 注册事件接收器的目标对象
     * 保证后续调度时 可以触发事件接收器定义的事件
     *
     * @param target
     * @return
     */
    boolean register(Object target) throws InvocationTargetException, IllegalAccessException;

    /**
     * unregister event target
     * 调用此方法后，不会再给当前对象发送任何事件
     *
     * @param target
     * @return
     */
    boolean unregister(Object target);
}

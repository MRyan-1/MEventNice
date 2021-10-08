package org.mryan.eventnice.core;

/**
 * @description： 注册中心
 * @Author MRyan
 * @Date 2021/10/8 23:45
 * @Version 1.0
 */
public interface Registry {

    /**
     * register event target
     *
     * @param target
     * @return
     */
    boolean register(Object target);

    /**
     * unregister event target
     *
     * @param target
     * @return
     */
    boolean unregister(Object target);
}

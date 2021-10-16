package org.myran.eventnicetest.listener.hierarchy;

import org.mryan.eventnice.annotation.EventReceive;

/**
 * @description： ListenerHierarchy
 * @Author MRyan
 * @Date 2021/10/10 15:01
 * @Version 1.0
 */
public class ListenerHierarchy extends BaseListener {

    @EventReceive
    public void task(String s) {
        System.out.println("do task(" + s + ")");
    }
}
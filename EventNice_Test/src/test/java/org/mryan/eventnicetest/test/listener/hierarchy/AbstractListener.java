package org.mryan.eventnicetest.test.listener.hierarchy;

import org.mryan.eventnice.annotation.EventReceive;

/**
 * @description： AbstractListener
 * @Author MRyan
 * @Date 2021/10/10 15:00
 * @Version 1.0
 */
public abstract class AbstractListener {

    @EventReceive
    public void commonTask(String s) {
        System.out.println("do commonTask(" + s + ")");
    }
}
package org.myran.eventnicetest.listener.hierarchy;

import org.mryan.eventnice.annotation.EventReceive;

/**
 * @description： BaseListener
 * @Author MRyan
 * @Date 2021/10/10 15:00
 * @Version 1.0
 */
public class BaseListener extends AbstractListener {

    @EventReceive
    public void baseTask(String s) {
        System.out.println("do baseTask(" + s + ")");
    }
}

package org.mryan.eventnicetest.test.listener;

import org.mryan.eventnice.annotation.EventReceive;

/**
 * @description： NumberListener
 * @Author MRyan
 * @Date 2021/10/8 23:00
 * @Version 1.0
 */
public class NumberListener {

    private Number lastMessage;

    @EventReceive
    public void listen(Number integer) {
        lastMessage = integer;
        System.out.println("Number Message:" + lastMessage);
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}
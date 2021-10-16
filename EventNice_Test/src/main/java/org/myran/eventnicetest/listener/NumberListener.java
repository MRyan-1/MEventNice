package org.myran.eventnicetest.listener;

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
        System.out.println("NumberListener Message:" + lastMessage);
    }

    public Number getLastMessage() {
        return lastMessage;
    }
}
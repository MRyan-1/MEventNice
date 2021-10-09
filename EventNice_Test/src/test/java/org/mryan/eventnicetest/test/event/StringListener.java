package org.mryan.eventnicetest.test.event;

import org.mryan.eventnice.annotation.EventReceive;

/**
 * @description： StringListener
 * @Author MRyan
 * @Date 2021/10/8 23:01
 * @Version 1.0
 */
public class StringListener {

    private String lastMessage;

    @EventReceive
    public void listen(String str) {
        lastMessage = str;
        System.out.println("Integer Message:" + lastMessage);
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
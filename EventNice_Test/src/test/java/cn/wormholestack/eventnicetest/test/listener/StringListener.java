package cn.wormholestack.eventnicetest.test.listener;

import cn.wormholestack.eventnice.annotation.EventReceive;

/**
 * @description： StringListener
 * @Author MRyan
 * @Date 2021/10/8 23:01
 * @Version 1.0
 */
public class StringListener {

    private static String lastMessage;

    @EventReceive
    public static void listen(String str) {
        lastMessage = str;
        System.out.println("StringListener Message:" + lastMessage);
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
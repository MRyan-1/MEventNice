package cn.wormholestack.eventnicetest.test.listener;

import cn.wormholestack.eventnice.annotation.EventReceive;

/**
 * @description： NumberListener
 * @Author MRyan
 * @Date 2021/10/8 23:00
 * @Version 1.0
 */
public class LongListener {

    private Long lastMessage;

    @EventReceive
    public void listen(Long integer) {
        lastMessage = integer;
        System.out.println("LongListener Message:" + lastMessage);
    }

    public Long getLastMessage() {
        return lastMessage;
    }
}
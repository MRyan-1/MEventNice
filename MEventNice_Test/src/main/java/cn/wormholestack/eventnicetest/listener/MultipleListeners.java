package cn.wormholestack.eventnicetest.listener;

import cn.wormholestack.eventnice.annotation.EventReceive;

/**
 * @description： MultipleListeners
 * @Author MRyan
 * @Date 2021/10/10 14:52
 * @Version 1.0
 */
public class MultipleListeners {

    @EventReceive
    public void task1(String s) {
        System.out.println("do task1(" + s + ")");
    }

    @EventReceive
    public void task2(String s) {
        System.out.println("do task2(" + s + ")");
    }

    @EventReceive
    public void intTask(Integer i) {
        System.out.println("do intTask(" + i + ")");
    }
}
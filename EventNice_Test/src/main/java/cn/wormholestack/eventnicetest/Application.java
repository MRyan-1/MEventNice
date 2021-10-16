package cn.wormholestack.eventnicetest;

import cn.wormholestack.eventnice.core.EventContext;
import cn.wormholestack.eventnicetest.listener.LongListener;

/**
 * @description： Application
 * @Author MRyan
 * @Date 2021/10/16 14:20
 * @Version 1.0
 */
public class Application {

    public static void main(String[] args) {
        EventContext context = new EventContext("This is a test case.");
        context.register(new LongListener());
        System.out.println("Post Simple EventBus Example");
        context.post(1);
        context.post(1L);
    }
}

package org.myran.eventnicetest;

import org.mryan.eventnice.core.EventContext;
import org.myran.eventnicetest.listener.LongListener;

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

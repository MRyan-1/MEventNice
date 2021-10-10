package org.mryan.eventnicetest.test;

import org.junit.Test;
import org.mryan.eventnice.core.EventContext;
import org.mryan.eventnicetest.test.event.IntegerListener;
import org.mryan.eventnicetest.test.event.NumberListener;
import org.mryan.eventnicetest.test.event.StringListener;


/**
 * @description： EventContext可用性测试类
 * @Author MRyan
 * @Date 2021/10/9 01:19
 * @Version 1.0
 */
public class EventContextTest {

    @Test
    public void TEST_BASE_EVENT_CONTEXT_INSTANTIATE() {
        EventContext context = new EventContext("This is a test case.");
        context.register(new IntegerListener());
        context.register(new NumberListener());
        context.post(1);
    }

    @Test
    public void TEST_BASE_EVENT_STRING() {
        EventContext context = new EventContext();
        context.register(new StringListener());
        context.post("This is a test case.");
    }

    @Test
    public void TEST_BASE_EVENT_UNREGISTER() {
        EventContext context = new EventContext();
        StringListener listener = new StringListener();
        context.register(listener);
        context.unregister(listener);
        context.post("This is a test case.");
    }

}

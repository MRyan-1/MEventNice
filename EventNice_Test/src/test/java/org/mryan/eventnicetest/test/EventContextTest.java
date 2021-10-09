package org.mryan.eventnicetest.test;

import org.junit.Test;
import org.mryan.eventnice.core.EventContext;
import org.mryan.eventnicetest.test.event.IntegerListener;

import java.lang.reflect.InvocationTargetException;


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
    }

}

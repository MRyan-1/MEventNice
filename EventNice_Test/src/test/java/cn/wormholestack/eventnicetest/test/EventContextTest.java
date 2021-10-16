package cn.wormholestack.eventnicetest.test;

import cn.wormholestack.eventnice.core.EventContext;
import cn.wormholestack.eventnicetest.test.event.MyEvent;
import org.junit.Test;
import cn.wormholestack.eventnicetest.test.event.*;
import cn.wormholestack.eventnicetest.test.event.hierarchy.Apple;
import cn.wormholestack.eventnicetest.test.event.hierarchy.Fruit;
import cn.wormholestack.eventnicetest.test.listener.IntegerListener;
import cn.wormholestack.eventnicetest.test.listener.MultipleListeners;
import cn.wormholestack.eventnicetest.test.listener.NumberListener;
import cn.wormholestack.eventnicetest.test.listener.StringListener;
import cn.wormholestack.eventnicetest.test.listener.hierarchy.FruitEaterListener;
import cn.wormholestack.eventnicetest.test.listener.hierarchy.ListenerHierarchy;

import java.util.concurrent.CountDownLatch;


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
        System.out.println("Post Simple EventBus Example");
        context.post(1);
    }

    @Test
    public void TEST_BASE_EVENT_STRING() {
        EventContext context = new EventContext();
        context.register(new StringListener());
        System.out.println("Post Simple EventBus Example");
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

    @Test
    public void TEST_BASE_EVENT_CUSTOM() {
        EventContext context = new EventContext();
        StringListener listener = new StringListener();
        context.register(listener);
        context.post(new MyEvent("this is a test case."));
    }

    /**
     * A class can listen to more than one type of event. In the below listener,
     * we have methods listening for String events and Integer event.
     */
    @Test
    public void TEST_MULTIPLE_EVENT_TYPE() {
        EventContext context = new EventContext();
        context.register(new MultipleListeners());
        System.out.println("Post 'Multiple Listeners Example'");
        context.post("Multiple Listeners Example");
        context.post(1);
    }


    /**
     * In this example, the listener class extends BaseListener which in turn extends AbstractListener.
     * Once an event is published, all the @EventReceive annotated methods in the listener’s hierarchy will be notified.
     */
    @Test
    //todo 待实现
    public void LISTENER_HIERARCHY_EVENT_RECEIVER_EXAMPLE() {
        EventContext context = new EventContext();
        context.register(new ListenerHierarchy());
        System.out.println("Post 'Listener Hierarchy Example'");
        context.post("Listener Hierarchy Example");
    }

    /**
     * If there are subscribers listening for concrete events and generic events, the concrete event listeners will get the notification first and then the generic ones.
     * In the below example, the FruitEaterListener contains a subscriber method called eat. It can eat generic fruit as well as specific fruit ‘Apple’. If an ‘Apple’ is published, first eat(Apple) gets notified and then eat(Fruit)
     */
    @Test
    //todo 待实现
    public void EVENT_HIERARCHY_EVENT_RECEIVER_EXAMPLE() {
        EventContext context = new EventContext();
        context.register(new FruitEaterListener());
        System.out.println("Post 'Apple'");
        context.post(new Apple());
        System.out.println("Post 'Orange as Fruit'");
        context.post(new Fruit("Orange"));
    }


    @Test
    public void TEST_EVENT_EXECUTOR() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        EventContext context = new EventContext();
        context.register(new StringListener());
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                context.post("This is a test case.");
                countDownLatch.countDown();
            }
        }).start();
        countDownLatch.await();
    }
}

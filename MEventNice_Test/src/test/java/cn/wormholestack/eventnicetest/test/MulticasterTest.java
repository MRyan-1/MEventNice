package cn.wormholestack.eventnicetest.test;

import cn.wormholestack.eventnice.core.EventContext;
import cn.wormholestack.eventnicetest.event.MEventInt;
import cn.wormholestack.eventnicetest.listener.MultipleListeners;
import cn.wormholestack.eventnicetest.listener.MyEventListener;
import cn.wormholestack.eventnicetest.listener.hierarchy.ListenerHierarchy;
import org.junit.Test;

/**
 * @description： 事件广播
 * @Author MRyan
 * @Date 2021/10/28 15:24
 */
public class MulticasterTest {

    private static EventContext context = EventContext.getDefault();

    static {
        context.register(new MyEventListener());
        context.register(new MultipleListeners());
        context.register(new ListenerHierarchy());
    }

    @Test
    public void MULTICASTER() {
        context.post(new MEventInt(new Integer(100)));
        context.post(new MEventInt(200));
        context.post("Multiple Listeners Example");
        context.post(1);
        context.post("Listener Hierarchy Example");
    }
}

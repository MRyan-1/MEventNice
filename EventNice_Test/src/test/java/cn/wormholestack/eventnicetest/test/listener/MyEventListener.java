package cn.wormholestack.eventnicetest.test.listener;

import cn.wormholestack.eventnicetest.test.event.MyEvent;
import cn.wormholestack.eventnice.annotation.EventReceive;

/**
 * @description： MyEventListener
 * @Author MRyan
 * @Date 2021/10/11 17:58
 */
public class MyEventListener {

    @EventReceive
    public String onEvent(MyEvent myEvent) {
        System.out.println("MyEventListener Message:" + myEvent);
        return myEvent.getMessage();
    }

}

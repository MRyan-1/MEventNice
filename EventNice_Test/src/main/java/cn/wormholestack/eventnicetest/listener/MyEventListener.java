package cn.wormholestack.eventnicetest.listener;

import cn.wormholestack.eventnice.annotation.EventReceive;
import cn.wormholestack.eventnicetest.event.MEventInt;
import cn.wormholestack.eventnicetest.event.MEventString;

/**
 * @description： MyEventListener
 * @Author MRyan
 * @Date 2021/10/11 17:58
 */
public class MyEventListener {

    @EventReceive
    public int onEvent(MEventInt myEvent) {
        System.out.println("MyEventListener IntMessage:" + myEvent);
        return myEvent.getMessage();
    }

    @EventReceive
    public String onEvent(MEventString myEvent) {
        System.out.println("MyEventListener StringMessage:" + myEvent);
        return myEvent.getMessage();
    }

    @EventReceive
    public void onEvent(Long event) {
        System.out.println("event Long:" + event);
    }

}

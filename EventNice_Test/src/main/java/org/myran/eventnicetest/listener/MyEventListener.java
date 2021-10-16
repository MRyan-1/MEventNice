package org.myran.eventnicetest.listener;

import org.mryan.eventnice.annotation.EventReceive;
import org.myran.eventnicetest.event.MEventInt;
import org.myran.eventnicetest.event.MEventString;

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

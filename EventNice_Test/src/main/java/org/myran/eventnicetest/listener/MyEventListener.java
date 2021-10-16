package org.myran.eventnicetest.listener;

import org.mryan.eventnice.annotation.EventReceive;
import org.myran.eventnicetest.event.MyEvent;

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

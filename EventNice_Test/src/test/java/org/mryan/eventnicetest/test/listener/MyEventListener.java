package org.mryan.eventnicetest.test.listener;

import org.mryan.eventnice.annotation.EventReceive;
import org.mryan.eventnicetest.test.event.MyEvent;

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

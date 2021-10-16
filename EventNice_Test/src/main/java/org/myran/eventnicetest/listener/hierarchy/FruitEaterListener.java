package org.myran.eventnicetest.listener.hierarchy;

import org.mryan.eventnice.annotation.EventReceive;
import org.myran.eventnicetest.event.hierarchy.Apple;
import org.myran.eventnicetest.event.hierarchy.Banana;
import org.myran.eventnicetest.event.hierarchy.Fruit;


/**
 * @description： FruitEaterListener
 * @Author MRyan
 * @Date 2021/10/10 15:08
 * @Version 1.0
 */
public class FruitEaterListener {

    @EventReceive
    public void eat(Fruit fruit) {
        System.out.println("eatFruit(Fruit " + fruit + ")");
    }

    @EventReceive
    public void eat(Apple apple) {
        System.out.println("eatApple(" + apple + ")");
    }

    @EventReceive
    public void eat(Banana banana) {
        System.out.println("eatBanana(" + banana + ")");
    }
}

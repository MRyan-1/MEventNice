package cn.wormholestack.eventnicetest.test.event.hierarchy;

/**
 * @description： Fruit
 * @Author MRyan
 * @Date 2021/10/10 15:08
 * @Version 1.0
 */
public class Fruit {

    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
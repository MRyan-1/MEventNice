package org.myran.eventnicetest.event;

/**
 * @description： MyEvent
 * @Author MRyan
 * @Date 2021/10/8 22:37
 * @Version 1.0
 */
public class MEventInt {

    private final int message;

    public MEventInt(int message) {
        this.message = message;
        System.out.println("event message:" + message);
    }

    public int getMessage() {
        return message;
    }
    @Override
    public String toString() {
        return "MyEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}

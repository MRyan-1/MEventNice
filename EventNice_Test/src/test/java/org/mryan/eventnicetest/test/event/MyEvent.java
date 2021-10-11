package org.mryan.eventnicetest.test.event;

/**
 * @description： MyEvent
 * @Author MRyan
 * @Date 2021/10/8 22:37
 * @Version 1.0
 */
public class MyEvent {

    private final String message;

    public MyEvent(String message) {
        this.message = message;
        System.out.println("event message:" + message);
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}

package cn.wormholestack.eventnice.exception;

/**
 * @description：
 * @Author MRyan
 * @Date 2021/10/8 23:57
 * @Version 1.0
 */
public class EventException extends RuntimeException {

    public EventException() {
        super();
    }

    public EventException(final Throwable throwable) {
        super(throwable);
    }

    public EventException(final String detailMessage) {
        super(detailMessage);
    }

    public EventException(final String detailMessage, final Throwable throwable) {
        super(detailMessage, throwable);
    }

}

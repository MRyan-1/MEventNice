package cn.wormholestack.eventnice.model;

/**
 * @description： ResultMsg
 * @Author MRyan
 * @Date 2021/10/20 15:49
 */
public class ResultMsg {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -8185452078060722380L;

    /**
     * The Result.
     */
    private boolean result = true;

    /**
     * The Message.
     */
    private String message;

    /**
     * The error code.
     */
    private String errorCode;

    /**
     * data
     */

    private Object obj;

    /**
     * Instantiates a new Result msg.
     */
    public ResultMsg() {
    }

    /**
     * Instantiates a new Result msg.
     *
     * @param result  the result
     * @param message the message
     */
    public ResultMsg(boolean result, String message, Object obj) {
        this.result = result;
        this.message = message;
        this.obj = obj;
    }

    public static ResultMsg success() {
        return new ResultMsg(true, "sucess", null);
    }

    public static ResultMsg success(Object obj) {
        return new ResultMsg(true, "SUCCESS", obj);
    }

    public static ResultMsg error(Object obj) {
        return new ResultMsg(false, "FAIL", obj);
    }

    public static ResultMsg error(String msg) {
        return new ResultMsg(false, msg, null);
    }

    /**
     * Instantiates a new Result msg.
     *
     * @param result  the result
     * @param message the message
     */
    public ResultMsg(boolean result, String message) {
        this(result, message, null);
    }

    /**
     * Is result boolean.
     *
     * @return the boolean
     */
    public boolean isResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     * @return the result
     */
    public ResultMsg setResult(boolean result) {
        this.result = result;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @return the message
     */
    public ResultMsg setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public ResultMsg setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}

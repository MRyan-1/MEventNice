package cn.wormholestack.eventnice.utils;

import cn.wormholestack.eventnice.model.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description： ValidateUtils
 * @Author MRyan
 * @Date 2021/10/20 15:47
 */
public class ParamValidator {

    private static final Logger logger = LoggerFactory.getLogger(ParamValidator.class);

    public static ResultMsg objectNullError(Object value, String msg) {
        if (value == null) {
            LoggerUtils.error(logger, msg);
            return new ResultMsg(false, msg, null);
        }
        return null;
    }

    public static ResultMsg idBlankError(String value, String message) {
        return blankError(value, message);
    }

    public static ResultMsg blankError(String value, String msg) {
        if (ObjectUtils.stringIsBlank(value)) {
            LoggerUtils.error(logger, msg);
            return new ResultMsg(false, msg, null);
        }
        return null;
    }
}


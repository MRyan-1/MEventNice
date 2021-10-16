package cn.wormholestack.eventnice.utils;

import org.slf4j.Logger;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * @description： 日志操作类
 * @Author MRyan
 * @Date 2021/10/10 21:49
 * @Version 1.0
 */

public class LoggerUtils {
    private LoggerUtils() {
    }

    public static void info(Logger logger, String format, Object... argArray) {
        if (logger.isInfoEnabled()) {
            logger.info(format, argArray);
        }
    }

    public static void info(Logger logger, String format, Throwable e, Object... argArray) {
        if (logger.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.info(ft.getMessage(), e);
        }
    }

    public static void warn(Logger logger, String format, Object... argArray) {
        logger.warn(format, argArray);
    }

    public static void warn(Logger logger, String format, Throwable e, Object... argArray) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
        logger.warn(ft.getMessage(), e);
    }

    public static void debug(Logger logger, String format, Object... argArray) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, argArray);
        }
    }

    public static void debug(Logger logger, String format, Throwable e, Object... argArray) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.debug(ft.getMessage(), e);
        }
    }

    public static void error(Logger logger, String format, Object... argArray) {
        logger.error(format, argArray);
    }

    public static void error(Logger logger, String format, Throwable e, Object... argArray) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
        logger.error(ft.getMessage(), e);
    }
}

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

    /**
     * 构造函数
     */
    private LoggerUtils() {
    }

    /**
     * Info级别记录日志
     *
     * @param logger   slf4j logger实现
     * @param format   日志模版
     * @param argArray 日志参数
     */
    public static void info(Logger logger, String format, Object... argArray) {
        if (logger.isInfoEnabled()) {
            logger.info(format, argArray);
        }
    }

    /**
     * Info级别记录日志
     *
     * @param logger   slf4j logger实现
     * @param format   日志模版
     * @param e        异常
     * @param argArray 日志参数
     */
    public static void info(Logger logger, String format, Throwable e, Object... argArray) {
        if (logger.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.info(ft.getMessage(), e);
        }
    }

    /**
     * Warn级别记录日志
     *
     * @param logger   slf4j logger实现
     * @param format   日志模版
     * @param argArray 日志参数
     */
    public static void warn(Logger logger, String format, Object... argArray) {
        logger.warn(format, argArray);
    }

    /**
     * Warn级别记录日志
     *
     * @param logger   slf4j logger实现
     * @param format   日志模版
     * @param e        异常
     * @param argArray 日志参数
     */
    public static void warn(Logger logger, String format, Throwable e, Object... argArray) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
        logger.warn(ft.getMessage(), e);
    }

    /**
     * Debug级别记录日志
     *
     * @param logger   slf4j logger实现
     * @param format   日志模版
     * @param argArray 日志参数
     */
    public static void debug(Logger logger, String format, Object... argArray) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, argArray);
        }
    }

    /**
     * Debug级别记录日志
     *
     * @param logger   slf4j logger实现
     * @param format   日志模版
     * @param e        异常
     * @param argArray 日志参数
     */
    public static void debug(Logger logger, String format, Throwable e, Object... argArray) {
        if (logger.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            logger.debug(ft.getMessage(), e);
        }
    }

    /**
     * 错误级别记录日志
     *
     * @param logger   slf4j logger实现
     * @param format   日志模版
     * @param argArray 日志参数
     */
    public static void error(Logger logger, String format, Object... argArray) {
        logger.error(format, argArray);
    }

    /**
     * 错误级别记录日志
     *
     * @param logger   slf4j logger实现
     * @param format   日志模版
     * @param e        异常
     * @param argArray 日志参数
     */
    public static void error(Logger logger, String format, Throwable e, Object... argArray) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
        logger.error(ft.getMessage(), e);
    }
}

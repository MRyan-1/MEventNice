package cn.wormholestack.eventnice.utils;

/**
 * @description： ObjectUtils
 * @Author MRyan
 * @Date 2021/10/20 15:56
 */
public class ObjectUtils {

    public static boolean stringIsBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean StringIsNotEmpty(final CharSequence cs) {
        return !stringIsEmpty(cs);
    }

    public static boolean stringIsEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

}

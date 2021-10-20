package org.eugeneforest.toolbox.common.utils;

import org.springframework.util.StringUtils;

/**
 * 自定义字符串工具类
 *
 * @author Eugene-Forest
 */
public class StringUtil extends StringUtils {

    /**
     * 判断是否为空字符串
     * @param str 被判断字符串
     * @return 如果为空，则返回true
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }

    /**
     * 判断字符串是否非空
     * @param str 被判断字符串
     * @return 如果不为空，则返回true
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}

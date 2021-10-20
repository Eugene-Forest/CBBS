package org.eugeneforest.toolbox.common.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.NumberUtils;

/**
 * 自定义数值类型工具类
 *
 * @author Eugene-Forest
 */
public class NumberUtil extends NumberUtils {

    /**
     * 将字符串转化为整数
     *
     * @param str 被转换的字符串
     * @return 如果成功则返回字符串str转换后的整数,否则返回-1
     */
    public static int toInt(final String str){
        return toInt(str, -1);
    }

    /**
     * 将字符串转化为整数
     *
     * @param str 被转换的字符串
     * @param defaultValue 转换失败时返回的值
     * @return 如果成功则返回字符串str转换后的整数,否则返回defaultValue
     */
    public static int toInt(@Nullable final String str, final int defaultValue){
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Integer.parseInt(str.trim());
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
    }

    /**
     * 将字符串转换为 long
     *
     * @param str 被转换的字符串
     * @return 如果成功则返回字符串str转换后的long,否则返回 -1
     */
    public static long toLong(final String str) {
        return toLong(str, -1L);
    }

    /**
     * 将字符串转换为 long
     *
     * @param str 被转换的字符串
     * @param defaultValue 转换失败时返回的值
     * @return 如果成功则返回字符串str转换后的long,否则返回defaultValue
     */
    public static long toLong(@Nullable final String str, final long defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Long.parseLong(str.trim());
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
    }

    /**
     * 将字符串转换为 double
     *
     * @param str 被转换的字符串
     * @return 如果成功则返回字符串str转换后的值,否则返回defaultValue
     */
    public static double toDouble(final String str){
        return toDouble(str, -1.0);
    }

    /**
     * 将字符串转换为 double
     *
     * @param str 被转换的字符串
     * @param defaultValue 转换失败时返回的值
     * @return 如果成功则返回字符串str转换后的值,否则返回defaultValue
     */
    public static double toDouble(@Nullable final String str,final double defaultValue){
        if (str == null){
            return defaultValue;
        }else {
            try {
                return Double.parseDouble(str.trim());
            }catch (NumberFormatException e){
                return defaultValue;
            }
        }
    }


    /**
     * 将字符串转换为 float
     *
     * @param str 被转换的字符串
     * @return 如果成功则返回字符串str转换后的值,否则返回defaultValue
     */
    public static float toFloat(final String str){
        return toFloat(str, -1);
    }

    /**
     * 将字符串转换为 float
     *
     * @param str 被转换的字符串
     * @param defaultVale 转换失败时返回的值
     * @return 如果成功则返回字符串str转换后的值,否则返回defaultValue
     */
    public static float toFloat(@Nullable final String str, final float defaultVale){
        if (str == null){
            return defaultVale;
        }else {
            try {
                return Float.parseFloat(str.trim());
            }catch (NumberFormatException e){
                return defaultVale;
            }
        }
    }


}

package org.eugeneforest.toolbox.common;

import org.eugeneforest.toolbox.common.utils.NumberUtil;
import org.eugeneforest.toolbox.common.utils.StringUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 工具类，提供静态方法
 *
 * @author Eugene-Forest
 */
public class Func {

    public static List<Long> toLongList(String str) {
        return Arrays.asList(toLongArray(str));
    }

    public static List<Long> toLongList(String split, String str) {
        return Arrays.asList(toLongArray(split, str));
    }

    public static Long[] toLongArray(String str) {
        return toLongArray(",", str);
    }

    public static Long[] toLongArray(String split, String str) {
        if (StringUtil.isEmpty(str)) {
            return new Long[0];
        } else {
            String[] arr = str.split(split);
            Long[] longs = new Long[arr.length];

            for(int i = 0; i < arr.length; ++i) {
                Long v = NumberUtil.toLong(arr[i], 0L);
                longs[i] = v;
            }

            return longs;
        }
    }



}

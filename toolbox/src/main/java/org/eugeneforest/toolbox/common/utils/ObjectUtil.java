package org.eugeneforest.toolbox.common.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

/**
 * 对象工具类
 *
 * @author Eugene-Forest
 */
public class ObjectUtil extends ObjectUtils {

    public static boolean isNotEmpty(@Nullable Object obj) {
        return !isEmpty(obj);
    }


}

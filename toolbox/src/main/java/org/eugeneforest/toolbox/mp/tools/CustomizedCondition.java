package org.eugeneforest.toolbox.mp.tools;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.eugeneforest.toolbox.api.Query;

/**
 * 自定义提取 wapper 的工具类
 *
 * @author Eugene-Forest
 */
public class CustomizedCondition<T> {

    public static <T> QueryWrapper<T> getQueryWrapper(T entity){
        return new QueryWrapper<>(entity);
    }

    public static <T> IPage<T> getPage(Query query){
        Page<T> page = new Page(query.getCurrent(), query.getSize());

        return page;
    }
}

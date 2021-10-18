package org.eugeneforest.toolbox.common.mp.base;

import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.constraints.NotEmpty;
import java.util.List;


/**
 * 自定义基础服务，继承mybatis plus的服务
 *
 * @author Eugene-Forest
 */
public interface CustomizedService<T> extends IService<T> {
    /**
     * 逻辑删除记录
     *
     * @param ids id数组
     */
    boolean deleteLogicByIds(@NotEmpty List<Long> ids);

    /**
     * 逻辑删除记录
     *
     * @param id id
     */
    boolean deleteLogicById(@NotEmpty Long id);

    /**
     * 改变记录状态
     *
     * @param ids id数组
     * @param status 目标状态
     */
    boolean changeStatus(@NotEmpty List<Long> ids, Integer status);


}

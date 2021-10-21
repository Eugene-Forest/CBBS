package org.eugeneforest.toolbox.mp.base;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotNull;
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
    boolean deleteLogicByIds(@NotNull List<Long> ids);

    /**
     * 逻辑删除记录
     *
     * @param id id
     */
    boolean deleteLogicById(@NotNull Long id);

    /**
     * 改变记录状态
     *
     * @param id     id
     * @param status 目标状态
     */
    boolean changeStatusById(@NotNull Long id, @NotNull Integer status);

    /**
     * 改变记录状态
     *
     * @param ids    id数组
     * @param status 目标状态
     */
    boolean changeStatusByBatchIds(@NotNull List<Long> ids, @NotNull Integer status);

    /**
     * 实际删除已经逻辑删除了的记录
     */
    boolean deleteById(@Param("id") Long id);

    /**
     * 批量实际删除已经逻辑删除了的记录
     */
    boolean deletedByBatchIds(@Param(value = "list") List<Long> idList);

}

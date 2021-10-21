package org.eugeneforest.toolbox.mp.component.sqlinjector.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Eugene-Forest
 */
public interface CustomizedMapper<T> extends BaseMapper<T> {
    /**
     * 逻辑删除
     */
    boolean logicDeleteById(Long id);

    /**
     * 批处理逻辑删除
     */
    boolean logicDeleteByBatchIds(@Param(value = "list") List<Long> idList);

    /**
     * 批处理更改状态
     * @param ids id集合
     * @param status 目标状态
     */
    boolean changeStatusByBatchIds(@Param("list") List<Long> ids,@Param("status") Integer status);

    /**
     * 更改记录状态
     * @param id id
     * @param status 目标状态
     */
    boolean changeStatusById(@Param("id") Long id,@Param("status") Integer status);

    /**
     * 实际删除已经逻辑删除了的记录
     */
    boolean deleteById(@Param("id") Long id);

    /**
     * 批量实际删除已经逻辑删除了的记录
     */
    boolean deletedByBatchIds(@Param(value = "list") List<Long> idList);

}

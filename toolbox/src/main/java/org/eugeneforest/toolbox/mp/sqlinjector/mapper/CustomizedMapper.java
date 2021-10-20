package org.eugeneforest.toolbox.mp.sqlinjector.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Eugene-Forest
 */
public interface CustomizedMapper<T> extends BaseMapper<T> {

    boolean logicDeleteById(Long id);

    boolean logicDeleteByBatchIds(@Param(value = "list") List<Long> idList);

    boolean changeStatus(@Param("list") List<Long> ids,@Param("status") Integer status);

}

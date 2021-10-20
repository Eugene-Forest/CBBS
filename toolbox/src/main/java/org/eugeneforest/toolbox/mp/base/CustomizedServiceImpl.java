package org.eugeneforest.toolbox.mp.base;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eugeneforest.toolbox.mp.sqlinjector.mapper.CustomizedMapper;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 自定义基础服务类，继承mybatis plus的服务类
 *
 * @author Eugene-Forest
 */
@Validated
public class CustomizedServiceImpl<M extends CustomizedMapper<T>, T extends CustomizedEntity> extends ServiceImpl<M, T> implements CustomizedService<T> {
    /**
     * 逻辑删除记录
     *
     * @param ids id数组
     */
    @Override
    public boolean deleteLogicByIds(List<Long> ids) {
        return baseMapper.logicDeleteByBatchIds(ids);
    }

    /**
     * 逻辑删除记录
     *
     * @param id id
     */
    @Override
    public boolean deleteLogicById(Long id) {
        return baseMapper.logicDeleteById(id);
    }


    /**
     * 改变记录状态
     *
     * @param ids    id数组
     * @param status 目标状态
     */
    @Override
    public boolean changeStatus(List<Long> ids, Integer status) {
        return baseMapper.changeStatus(ids, status);
    }
}

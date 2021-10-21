package org.eugeneforest.toolbox.mp.base;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.eugeneforest.toolbox.mp.component.sqlinjector.mapper.CustomizedMapper;
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
     * @param id     id
     * @param status 目标状态
     */
    @Override
    public boolean changeStatusById(Long id, Integer status) {
        if (id==null || status==null){
            return false;
        }
        return baseMapper.changeStatusById(id, status);
    }


    /**
     * 改变记录状态
     *
     * @param ids    id数组
     * @param status 目标状态
     */
    @Override
    public boolean changeStatusByBatchIds(List<Long> ids, Integer status) {
        if (ids ==null|| status==null){
            return false;
        }
        return baseMapper.changeStatusByBatchIds(ids, status);
    }

    /**
     * 实际删除已经逻辑删除了的记录
     *
     * @param id
     */
    @Override
    public boolean deleteById(Long id) {
        if (id==null){
            return false;
        }
        return baseMapper.deleteById(id);
    }

    /**
     * 批量实际删除已经逻辑删除了的记录
     *
     * @param idList
     */
    @Override
    public boolean deletedByBatchIds(List<Long> idList) {
        if (idList==null){
            return false;
        }
        return baseMapper.deletedByBatchIds(idList);
    }
}

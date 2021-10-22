package org.eugeneforest.cbbs.base.mapper;

import org.eugeneforest.cbbs.base.entity.UserTable;
import org.eugeneforest.toolbox.mp.component.sqlinjector.mapper.CustomizedMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Eugene-Forest
 * @since 2021-10-22 11:04:50
 */
@Mapper
public interface UserTableDao extends CustomizedMapper<UserTable> {

}

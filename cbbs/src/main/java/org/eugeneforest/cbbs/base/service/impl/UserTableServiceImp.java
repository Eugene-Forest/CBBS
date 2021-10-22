package org.eugeneforest.cbbs.base.service.impl;

import org.eugeneforest.cbbs.base.entity.UserTable;
import org.eugeneforest.cbbs.base.mapper.UserTableDao;
import org.eugeneforest.cbbs.base.service.UserTableService;
import org.eugeneforest.toolbox.mp.base.CustomizedServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Eugene-Forest
 * @since 2021-10-22 11:04:50
 */
@Service
public class UserTableServiceImp extends CustomizedServiceImpl<UserTableDao, UserTable> implements UserTableService {

}

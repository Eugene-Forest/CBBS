package org.eugeneforest.cbbs;

import org.eugeneforest.cbbs.base.entity.UserTable;
import org.eugeneforest.cbbs.base.service.UserTableService;
import org.eugeneforest.toolbox.mp.tools.CustomizedCondition;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class CbbsApplicationTests {

    @Resource
    private UserTableService userTableService;

    @Test
    void contextLoads() {
        UserTable user=new UserTable();
        user.setId(888L);
        user.setUserName("eugene");
        userTableService.saveOrUpdate(user);
        user.setBirthday(new Date());
        userTableService.saveOrUpdate(user);
        userTableService.remove(CustomizedCondition.getQueryWrapper(user).eq("id", user.getId()));
        List<Long> list=new ArrayList<>();
        list.add(3L);
        list.add(2L);
        userTableService.changeStatusByBatchIds(list, 10);
        userTableService.deletedByBatchIds(list);
    }

}

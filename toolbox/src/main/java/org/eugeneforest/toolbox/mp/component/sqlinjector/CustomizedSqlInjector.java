package org.eugeneforest.toolbox.mp.component.sqlinjector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.eugeneforest.toolbox.mp.component.sqlinjector.methods.ChangeStatus;
import org.eugeneforest.toolbox.mp.component.sqlinjector.methods.LogicDeleteByBatchIds;
import org.eugeneforest.toolbox.mp.component.sqlinjector.methods.LogicDeleteById;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义基础 sql 注入器类
 *
 * @author Eugene-Forest
 */
@Component
public class CustomizedSqlInjector extends DefaultSqlInjector {

    /**
     * 注意：需要作为一个组件注入才会生效
     */

    /**
     * 如果只需增加方法，保留MP自带方法
     * 可以super.getMethodList() 再add
     * @return
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        //添加mybatis原有的基础方法
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        //添加自定义方法
        methodList.add(new LogicDeleteByBatchIds());
        methodList.add(new LogicDeleteById());
        methodList.add(new ChangeStatus());
        return methodList;
    }
}

package org.eugeneforest.toolbox.mp.component.sqlinjector.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 通过id实现状态改变
 */
public class ChangeStatusById extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        /* 执行 SQL ，动态 SQL 参考类 SqlMethod */
        String sql = "update " + tableInfo.getTableName() + " set status=#{status} where id = %s and is_deleted = 0";
        /* mapper 接口方法名一致 */
        String method = "changeStatusById";

        StringBuilder valueSql = new StringBuilder();
        valueSql.append("#{").append(tableInfo.getKeyProperty()).append("}");

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sql,valueSql), modelClass);
        return this.addUpdateMappedStatement(mapperClass,modelClass,method, sqlSource);
    }
}

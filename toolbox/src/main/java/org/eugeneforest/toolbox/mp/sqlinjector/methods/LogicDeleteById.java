package org.eugeneforest.toolbox.mp.sqlinjector.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;


/**
 * 实现通过id逻辑删除的方法
 *
 * @author Eugene-Forest
 */
public class LogicDeleteById extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        /* 执行 SQL ，动态 SQL 参考类 SqlMethod */
        String sql = "update " + tableInfo.getTableName() + " set is_deleted = 1 where id = %s";
        /* mapper 接口方法名一致 */
        String method = "logicDeleteById";

        StringBuilder valueSql = new StringBuilder();
        valueSql.append("#{").append(tableInfo.getKeyProperty()).append("}");

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sql,valueSql), modelClass);
        return this.addUpdateMappedStatement(mapperClass,modelClass,method, sqlSource);
    }



}

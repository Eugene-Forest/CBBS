package org.eugeneforest.toolbox.mp.component.sqlinjector.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.eugeneforest.toolbox.mp.component.sqlinjector.common.SqlStringBuilder;

/**
 *
 * 批量删除已经逻辑删除了的记录
 * @author Eugene-Forest
 */
public class DeletedByBatchIds extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        /* 执行 SQL ，动态 SQL 参考类 SqlMethod */
        String sql = "<script>delete from " + tableInfo.getTableName() + " where id in %s and is_deleted = 1</script>";
        /* mapper 接口方法名一致 */
        String method = "deletedByBatchIds";

        //基本类型列表通用，需要在方法中注明列表参数别名为list
        StringBuilder valueSql = SqlStringBuilder.getBaseListSql();

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sql,valueSql), modelClass);
        return this.addDeleteMappedStatement(mapperClass,method,sqlSource);
    }

}

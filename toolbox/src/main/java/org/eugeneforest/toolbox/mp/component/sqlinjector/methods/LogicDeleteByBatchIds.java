package org.eugeneforest.toolbox.mp.component.sqlinjector.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.eugeneforest.toolbox.mp.component.sqlinjector.common.SqlStringBuilder;


/**
 * 通过ids实现批量逻辑删除
 *
 * @author Eugene-Forest
 */
public class LogicDeleteByBatchIds extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {

        /* 执行 SQL ，动态 SQL 参考类 SqlMethod */
        String sql = "<script>update " + tableInfo.getTableName() + " set is_deleted = 1 where id in %s</script>";
        /* mapper 接口方法名一致 */
        String method = "logicDeleteByBatchIds";

        //基本类型列表通用，需要在方法中注明列表参数别名为list
        StringBuilder valueSql = SqlStringBuilder.getBaseListSql();

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sql,valueSql), modelClass);
        return this.addUpdateMappedStatement(mapperClass,modelClass,method, sqlSource);
    }
}

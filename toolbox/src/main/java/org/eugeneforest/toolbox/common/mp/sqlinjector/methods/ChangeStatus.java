package org.eugeneforest.toolbox.common.mp.sqlinjector.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 通过ids实现状态改变
 *
 * @author Eugene-Forest
 */
public class ChangeStatus extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        /* 执行 SQL ，动态 SQL 参考类 SqlMethod */
        String sql = "<script>update " + tableInfo.getTableName() + " set status = #{status} where id in %s</script>";
        /* mapper 接口方法名一致 */
        String method = "changeStatus";

        //基本类型列表通用，需要在方法中注明列表参数别名为list
        StringBuilder valueSql = new StringBuilder();
        valueSql.append("<foreach collection=\"list\" item=\"item\" index=\"index\" open=\"(\" separator=\",\" close=\")\">");
        valueSql.append("#{item}");
        valueSql.append("</foreach>");

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sql,valueSql), modelClass);
        return this.addUpdateMappedStatement(mapperClass,modelClass,method, sqlSource);
    }
}

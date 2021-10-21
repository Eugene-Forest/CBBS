package org.eugeneforest.toolbox.mp.component.sqlinjector.common;

/**
 * sql语句构造器
 *
 * @author Eugene-Forest
 */
public class SqlStringBuilder {

    public static StringBuilder getBaseListSql(){
        //基本类型列表通用，需要在方法中注明列表参数别名为list
        StringBuilder valueSql = new StringBuilder();
        valueSql.append("<foreach collection=\"list\" item=\"item\" index=\"index\" open=\"(\" separator=\",\" close=\")\">");
        valueSql.append("#{item}");
        valueSql.append("</foreach>");
        return valueSql;
    }



}

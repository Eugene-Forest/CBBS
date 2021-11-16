package org.eugeneforest.toolbox.mp.generator;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.SqlServerTypeConvert;

import javax.validation.constraints.NotNull;

/**
 * @author Eugene-Forest
 * @date 2021/11/9
 **/
public class DataSourceBuilder {

    /**
     * 获取Mysql的数据源配置
     *
     * @param host ip地址
     * @param databaseName 数据库名
     * @param userName 用户名
     * @param password 密码
     * @return Mysql 数据源配置
     */
    public static DataSourceConfig.Builder getMysqlDataResourceConfig(@NotNull String host, @NotNull String databaseName,
                                                               @NotNull String userName, @NotNull String password){
        return new DataSourceConfig.Builder(
                "jdbc:mysql://"+host+":3306/"+databaseName,userName,password
        ).typeConvert(CustomizedTypeConvert.MYSQL_DEFAULT_TYPE_CONVERT);
    }

    /**
     * 获取mysql的数据源配置
     *
     * @param host ip地址
     * @param databaseName 数据库名
     * @param userName 用户名
     * @param password 密码
     * @param mysqlTypeConvert 自定义的数据类型转换
     * @return Mysql 数据源配置
     *
     */
    public static DataSourceConfig.Builder getMysqlDataResourceConfig(@NotNull String host,@NotNull String databaseName,
                                                               @NotNull String userName,@NotNull String password,
                                                               @NotNull MySqlTypeConvert mysqlTypeConvert){
        return new DataSourceConfig.Builder(
                "jdbc:mysql://"+host+":3306/"+databaseName,userName,password
        ).typeConvert(mysqlTypeConvert);
    }


    /**
     * 获取mssql的数据源配置
     *
     * @param host ip地址
     * @param databaseName 数据库名
     * @param userName 用户名
     * @param password 密码
     * @return mssql 数据源配置
     */
    public static DataSourceConfig.Builder getMssqlDataResourceConfig(@NotNull String host,@NotNull String databaseName,
                                                               @NotNull String userName,@NotNull String password){
        return new DataSourceConfig.Builder(
                "jdbc:sqlserver://"+host+":1433;DatabaseName="+databaseName,userName,password
        ).typeConvert(CustomizedTypeConvert.MSSQL_DEFAULT_TYPE_CONVERT);
    }

    /**
     * 获取mssql的数据源配置
     *
     * @param host ip地址
     * @param databaseName 数据库名
     * @param userName 用户名
     * @param password 密码
     * @param sqlServerTypeConvert 自定义的数据类型转换
     * @return mssql 数据源配置
     *
     */
    public static DataSourceConfig.Builder getMssqlDataResourceConfig(@NotNull String host,@NotNull String databaseName,
                                                               @NotNull String userName,@NotNull String password,
                                                               @NotNull SqlServerTypeConvert sqlServerTypeConvert){
        return new DataSourceConfig.Builder(
                "jdbc:sqlserver://"+host+":1433;DatabaseName="+databaseName,userName,password
        ).typeConvert(sqlServerTypeConvert);
    }
}

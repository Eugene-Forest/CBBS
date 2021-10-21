package org.eugeneforest.toolbox.mp.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.SqlServerTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import org.eugeneforest.toolbox.mp.base.CustomizedEntity;
import org.eugeneforest.toolbox.mp.base.CustomizedService;
import org.eugeneforest.toolbox.mp.base.CustomizedServiceImpl;
import org.eugeneforest.toolbox.mp.component.sqlinjector.mapper.CustomizedMapper;

import javax.validation.constraints.NotNull;

/**
 * 交互式生成代码模板配置
 *
 * @author Eugene-Forest
 */
public class InteractiveSqlGenerator {

    /**
     * 获取mssql的数据源配置
     *
     * @param host ip地址
     * @param databaseName 数据库名
     * @param userName 用户名
     * @param password 密码
     * @return mssql 数据源配置
     */
    public DataSourceConfig.Builder getMssqlDataResourceConfig(@NotNull String host,@NotNull String databaseName,
                                                                @NotNull String userName,@NotNull String password){
        return new DataSourceConfig.Builder(
                "jdbc:sqlserver://"+host+":1433;DatabaseName="+databaseName,userName,password
        ).typeConvert(FastSqlGenerator.MSSQL_DEFAULT_TYPE_CONVERT);
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
    public DataSourceConfig.Builder getMssqlDataResourceConfig(@NotNull String host,@NotNull String databaseName,
                                                                @NotNull String userName,@NotNull String password,
                                                                @NotNull SqlServerTypeConvert sqlServerTypeConvert){
        return new DataSourceConfig.Builder(
                "jdbc:sqlserver://"+host+":1433;DatabaseName="+databaseName,userName,password
        ).typeConvert(sqlServerTypeConvert);
    }



    /**
     * 获取Mysql的数据源配置
     *
     * @param host ip地址
     * @param databaseName 数据库名
     * @param userName 用户名
     * @param password 密码
     * @return Mysql 数据源配置
     */
    public DataSourceConfig.Builder getMysqlDataResourceConfig(@NotNull String host,@NotNull String databaseName,
                                                                @NotNull String userName,@NotNull String password){
        return new DataSourceConfig.Builder(
                "jdbc:sqlserver://"+host+":1433;DatabaseName="+databaseName,userName,password
        ).typeConvert(FastSqlGenerator.MYSQL_DEFAULT_TYPE_CONVERT);
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
    public DataSourceConfig.Builder getMysqlDataResourceConfig(@NotNull String host,@NotNull String databaseName,
                                                                @NotNull String userName,@NotNull String password,
                                                                @NotNull MySqlTypeConvert mysqlTypeConvert){
        return new DataSourceConfig.Builder(
                "jdbc:sqlserver://"+host+":1433;DatabaseName="+databaseName,userName,password
        ).typeConvert(mysqlTypeConvert);
    }


    /**
     * 代码生成
     *
     * @param root
     * @param parent
     * @param dataSourceConfig
     */
    public void run(String root,String parent,DataSourceConfig.Builder dataSourceConfig){
        FastAutoGenerator.create(dataSourceConfig)
                // 全局配置
                .globalConfig((scanner, builder) -> builder
                        .fileOverride()
                        .author(scanner.apply("请输入作者名称？"))
                        .outputDir(root)
                        .enableSwagger()
                        .dateType(DateType.TIME_PACK)
                        .commentDate("yyyy-MM-dd hh:mm:ss").build())
                // 包配置
                .packageConfig((scanner, builder) -> builder
                        .parent(parent)
                        .moduleName(scanner.apply("请输入模块名？"))
                        .entity("entity")
                        .mapper("mapper")
                        .xml("mapper.xml")
                        .service("service")
                        .serviceImpl("service.impl")
                        .controller("controller")
                        .build())
                //模板设置
                .templateConfig((scanner, builder) -> builder
                        .entity("/templates/entity.java")
                        .service("/templates/service.java")
                        .serviceImpl("/templates/serviceImpl.java")
                        .mapper("/templates/mapper.java")
                        .mapperXml("/templates/mapper.xml")
                        .controller("/templates/controller.java").build())
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(
                                FastSqlGenerator.getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder()
                        .formatFileName("%sController")
                        .enableRestStyle()
                        .entityBuilder()
                        .superClass(CustomizedEntity.class)
                        .disableSerialVersionUID()
                        .enableTableFieldAnnotation()
                        .serviceBuilder()
                        .superServiceClass(CustomizedService.class)
                        .superServiceImplClass(CustomizedServiceImpl.class)
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImp")
                        .mapperBuilder()
                        .superClass(CustomizedMapper.class)
                        .formatMapperFileName("%sDao")
                        .formatXmlFileName("%sXml")
                        .enableMapperAnnotation()
                        .enableBaseResultMap()
                        .build())
//                模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
//               .templateEngine(new BeetlTemplateEngine())
//               .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}

package org.eugeneforest.toolbox.mp.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import org.eugeneforest.toolbox.mp.base.CustomizedEntity;
import org.eugeneforest.toolbox.mp.base.CustomizedService;
import org.eugeneforest.toolbox.mp.base.CustomizedServiceImpl;
import org.eugeneforest.toolbox.mp.component.sqlinjector.mapper.CustomizedMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速生成代码模板配置
 *
 * @author Eugene-Forest
 */
public class FastSqlGenerator{

    /**
     * mssql数据源配置
     */
    public static final DataSourceConfig.Builder MSSQL_DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder( "jdbc:sqlserver://localhost:1433;DatabaseName=cbbs",
            "sa", "1244303915").typeConvert(CustomizedTypeConvert.MSSQL_DEFAULT_TYPE_CONVERT);

    /**
     * mysql数据源配置
     */
    public static final DataSourceConfig.Builder MYSQL_DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder( "jdbc:mysql://localhost:3306/xinfeng_cube",
            "root", "1244303915").typeConvert(CustomizedTypeConvert.MYSQL_DEFAULT_TYPE_CONVERT);


    /**
     * 执行 run
     */
    public static void main(String[] args) {
        FastAutoGenerator.create(MYSQL_DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig( builder -> builder
                        .fileOverride()
                        .author("Eugene-Forest")
                        .outputDir("C:\\Users\\qaz22\\workspace-WorkCatalog\\caster\\cbbs\\src\\main\\java")
                        .enableSwagger()
                        .dateType(DateType.TIME_PACK)
                        .commentDate("yyyy-MM-dd hh:mm:ss").build())
                // 包配置
                .packageConfig( builder -> builder
                        .parent("org.eugeneforest.cbbs")
                        .moduleName("base")
                        .entity("entity")
                        .mapper("mapper")
                        .xml("mapper.xml")
                        .service("service")
                        .serviceImpl("service.impl")
                        .controller("controller")
                        .build())
                //模板设置
                .templateConfig(builder -> builder
                        .entity("/templates/entity.java")
                        .service("/templates/service.java")
                        .serviceImpl("/templates/serviceImpl.java")
                        .mapper("/templates/mapper.java")
                        .mapperXml("/templates/mapper.xml")
                        .controller("/templates/controller.java").build())
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(
                        getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
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

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}

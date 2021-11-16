package org.eugeneforest.toolbox.mp.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import org.eugeneforest.toolbox.mp.base.CustomizedEntity;
import org.eugeneforest.toolbox.mp.base.CustomizedService;
import org.eugeneforest.toolbox.mp.base.CustomizedServiceImpl;
import org.eugeneforest.toolbox.mp.component.sqlinjector.mapper.CustomizedMapper;

/**
 * 交互式生成代码模板配置
 *
 * @author Eugene-Forest
 */
public class InteractiveSqlGenerator {


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

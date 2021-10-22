package org.eugeneforest.cbbs.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @author Eugene-Forest
 */
@EnableOpenApi
@Configuration
public class Knife4jConfiguration  {

    @Bean
    public Docket defaultApi2() {

        Docket docket=new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("CBBS 的接口文档")
                        .description("cbbs APIs")
//                        .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("Eugene Forest", "http://www.pengweiquan.top/", "1244303915@qq.com"))
                        .version("1.0")
                        .build())
                //分组名称
                .groupName("α版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("org.eugeneforest.cbbs"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}

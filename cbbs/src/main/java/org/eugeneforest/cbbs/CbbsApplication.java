package org.eugeneforest.cbbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"org.eugeneforest.toolbox","org.eugeneforest.cbbs"})
public class CbbsApplication {

    //添加 对兄弟模块的扫描支持

    public static void main(String[] args) {
        SpringApplication.run(CbbsApplication.class, args);
    }

}

package org.eugeneforest.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.eugeneforest.homepage", "org.eugeneforest.toolbox"})
public class HomePageApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomePageApplication.class, args);
    }

}

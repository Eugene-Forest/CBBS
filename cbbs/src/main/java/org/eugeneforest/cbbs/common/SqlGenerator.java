package org.eugeneforest.cbbs.common;

import org.eugeneforest.toolbox.mp.generator.InteractiveSqlGenerator;

/**
 * 一个测试交互生成后端代码的类
 */
public class SqlGenerator {

    public static void main(String[] args) {
        InteractiveSqlGenerator sqlGenerator=new InteractiveSqlGenerator();
        sqlGenerator.run("C:\\Users\\qaz22\\workspace-WorkCatalog\\caster\\cbbs\\src\\main\\java",
                "org.eugeneforest.cbbs", sqlGenerator.getMssqlDataResourceConfig(
                        "localhost","cbbs", "sa", "1244303915"));
    }

}

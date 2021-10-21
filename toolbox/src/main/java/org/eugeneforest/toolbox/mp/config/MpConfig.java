package org.eugeneforest.toolbox.mp.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.eugeneforest.toolbox.mp.component.CustomizedMetaObjectHandler;
import org.eugeneforest.toolbox.mp.component.sqlinjector.CustomizedSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis plus 的配置
 */
@Configuration
public class MpConfig {

    /**
     * mybatis plus 【分页插件,乐观锁】 的配置
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //分页插件:数据库类型以实际
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.SQL_SERVER));
        //乐观锁
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

        return interceptor;
    }

    /**
     * mybatis plus 的 自动填充功能 的配置
     */
    @Bean
    public CustomizedMetaObjectHandler customizedMetaObjectHandler(){
        return new CustomizedMetaObjectHandler();
    }

    /**
     * mybatis plus 的 sql 注入器 的配置
     */
    @Bean
    public CustomizedSqlInjector customizedSqlInjector(){
        return new CustomizedSqlInjector();
    }

}

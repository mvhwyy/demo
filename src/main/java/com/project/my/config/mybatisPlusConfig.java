package com.project.my.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author mawei
 * @version 1.0
 * @name mybatisPlusConfig
 * @description TODO
 * @menu TODO
 * @date 2022/10/14 6:37 下午
 */
@Configuration
@MapperScan("com.project.my.mapper*")
public class mybatisPlusConfig {

    /*
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


//    @Bean(name = "sqlsession")
//    public SqlSessionFactory sqlSession(@Qualifier("masterCouponDataSource") DataSource dataSource,
//                                        @Qualifier("pageInterceptor") PaginationInterceptor pageInterceptor) throws Exception {
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setPlugins(new Interceptor[]{pageInterceptor});
//        return sqlSessionFactory.getObject();
//    }
}

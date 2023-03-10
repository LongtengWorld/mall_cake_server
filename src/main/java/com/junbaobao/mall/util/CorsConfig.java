package com.junbaobao.mall.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * @Classname CorsConfig
 * @Description
 * @Date: Created in 2022/9/19 21:45
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //需要跨域的地址 注意127.0.0.1 ！= localhost
        //* 表示对所有的地址都可以访问
        corsConfiguration.addAllowedOrigin("*");
        //跨域请求头
        corsConfiguration.addAllowedHeader("*");
        //跨域的请求方法
        corsConfiguration.addAllowedMethod("*");
        //跨域保证同一个session
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //配置可以访问的地址
        source.registerCorsConfiguration("/**",buildConfig());
        return new CorsFilter(source);
    }
}

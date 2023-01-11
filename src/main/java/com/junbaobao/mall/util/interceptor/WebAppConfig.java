/*
package com.junbaobao.mall.util.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

*/
/**
 * @Classname WebAppconfig
 * @Description
 * @Date: Created in 2022/7/21 11:11
 * @Author Name:  junbaobao
 * @Version: 1.0
 *//*

@Configuration
public class WebAppConfig  implements WebMvcConfigurer {

    @Resource
    private  AccessInterceptor accessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录拦截的管理器
        //拦截的对象会进入这个类中进行判断
        InterceptorRegistration registration = registry.addInterceptor(accessInterceptor);

    }
}
*/

package com.junbaobao.mall.util;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 返回值处理
 * NULL转空字符串
 * @author lyc
 */

public class MyFastJsonConfig extends WebMvcConfigurationSupport {

    /**
     * 使用阿里 fastjson 作为JSON MessageConverter
     * 需要fastjson依赖
     * <dependency>
     *     <groupId>com.alibaba</groupId>
     *     <artifactId>fastjson</artifactId>
     *     <version>1.2.76</version>
     * </dependency>
     * @param converters
     */

    /**
     * 源码解释：
     *  重写此方法以添加自定义 {@link HttpMessageConverter HttpMessageConverters}
     *  以与 {@link RequestMappingHandlerAdapter}
     *  和 {@link ExceptionHandlerExceptionResolver} 一起使用。
     *  <p>将转换器添加到列表会关闭默认情况下会注册的默认转换器。另请参阅 {@link addDefaultHttpMessageConverters}
     *  添加默认消息转换器。
     *  @param converters 将消息转换器添加到的列表（最初是一个空列表）
     *
     *
     * Override this method to add custom {@link HttpMessageConverter HttpMessageConverters}
     * to use with the {@link RequestMappingHandlerAdapter} and the
     * {@link ExceptionHandlerExceptionResolver}.
     * <p>Adding converters to the list turns off the default converters that would
     * otherwise be registered by default. Also see {@link #addDefaultHttpMessageConverters}
     * for adding default message converters.
     * @param converters a list to add message converters to (initially an empty list)
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
                // 保留map空的字段
                SerializerFeature.WriteMapNullValue,
                // 将String类型的null转成""
                SerializerFeature.WriteNullStringAsEmpty,
                // 将Number类型的null转成0
                SerializerFeature.WriteNullNumberAsZero,
                // 将List类型的null转成[]
                SerializerFeature.WriteNullListAsEmpty,
                // 将Boolean类型的null转成false
                SerializerFeature.WriteNullBooleanAsFalse,
                // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect);

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        List<MediaType> mediaTypeList = new ArrayList<>();
        // 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);
        converters.add(converter);
    }

    /**
     * 源码解释：
     *  覆盖此方法以添加资源处理程序以提供静态资源
     * 	Override this method to add resource handlers for serving static resources.
     * 	@see ResourceHandlerRegistry
     *
     * 解决的问题：
     *  静态资源不可以访问，例如swagger页面
     *
     *  @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/**"})
                .addResourceLocations(new String[]{"classpath:/static/"});
        registry.addResourceHandler(new String[]{"doc.html"})
                .addResourceLocations(new String[]{"classpath:/META-INF/resources/"});
        registry.addResourceHandler(new String[]{"/webjars/**"})
                .addResourceLocations(new String[]{"classpath:/META-INF/resources/webjars/"});
        super.addResourceHandlers(registry);
    }
}

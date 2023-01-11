package com.junbaobao.mall.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname Authorize
 * @Description 是否判断是否需要token
 * @Date: Created in 2022/7/21 15:27
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AllowAnonymous {
    boolean required() default true;
}

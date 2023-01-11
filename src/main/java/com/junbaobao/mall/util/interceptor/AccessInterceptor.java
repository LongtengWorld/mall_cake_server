/*
package com.junbaobao.mall.util.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.junbaobao.mall.util.JWTUtil;
import com.junbaobao.mall.util.annotation.AllowAnonymous;
import com.junbaobao.mall.util.exception.ExceptionRun;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

*/
/**
 * @Classname AccessInterceptor
 * @Description
 * @Date: Created in 2022/7/21 10:23
 * @Author Name:  junbaobao
 * @Version: 1.0
 *//*

@Slf4j
@Component
public class AccessInterceptor implements HandlerInterceptor {


    @Resource
    private CakeUserService cakeUserService;

    @Resource
    private JWTUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("开始执行拦截器");

        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //判断方法上是否有主键 如果有就需要进行跳过token验证
        if (method.isAnnotationPresent(AllowAnonymous.class)) {
            AllowAnonymous passToken = method.getAnnotation(AllowAnonymous.class);
            if (passToken.required()) {
                return true;
            }
        }
        //获取请求头中是否携带token
        String token = request.getHeader("Access-Token");

        if (StrUtil.isBlank(token)) {
            throw new ExceptionRun(401, "没有找到用户信息");
        }


        //判断openId是否已经存在DB中
        QueryWrapper<CakeUser> wrapper = new QueryWrapper<>();
        String openId = null;
        try {
            Claims claims = jwtUtil.parseJWT(token);
            openId = claims.get("openId").toString();
        } catch (Exception e) {
            log.error("解析Access-Token出现问题{}", e.getMessage());
            e.printStackTrace();
            throw new ExceptionRun(500, "无效访问");
        }

        wrapper.eq("open_id", openId);
        CakeUser cakeUser = cakeUserService.getOne(wrapper);
        if (ObjectUtil.isNull(cakeUser)) {
            throw new ExceptionRun(500, "当前账号并没有授权登录微信，请确认授权后在进行操作");
        }

        log.info("拦截器执行完毕");
        //return true;
        request.setAttribute("open_id",openId);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
*/

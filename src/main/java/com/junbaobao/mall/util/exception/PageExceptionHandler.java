package com.junbaobao.mall.util.exception;

/**
 * @Classname PageExceptionHandler
 * @Description
 * @Date: Created in 2022/7/21 11:45
 * @Author Name:  junbaobao
 * @Version: 1.0
 */

import com.junbaobao.mall.util.JsonResult;
import com.junbaobao.mall.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class PageExceptionHandler {

    /***
     * Token认证异常
     */
    @ResponseBody
    @ExceptionHandler(ExceptionRun.class)
    public JsonResult<Result> handleException(ExceptionRun e) {
        log.info("进入到了全局异常处理");
        return Result.customizeFailed(e.getCode(),e.getMessage());
    }


//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    public JsonResult<Result> handleRuntimeException(RuntimeException e) {
//        log.info("系统报错",e);
//        return Result.customizeFailed(500,e.getMessage());
//    }
}


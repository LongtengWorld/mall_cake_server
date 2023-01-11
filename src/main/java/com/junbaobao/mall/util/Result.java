package com.junbaobao.mall.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Result {
    //成功，不返回具体数据
    public static <T> JsonResult<T> successNoData(ResultCode code) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }
//    //成功，返回数据
//    public static <T> JsonResult<T> success(T t,ResultCode code){
//        JsonResult<T> result = new JsonResult<T>();
//        result.setCode(code.getCode());
//        result.setMsg(code.getMsg());
//        result.setData(t);
//        return result;
//    }

    //成功，返回数据
    public static <T> JsonResult<T> success(T t) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(t);
        log.info("封装返回工具类返回数据为,{}", result.toString());
        return result;
    }

    //成功，返回数据
    public static <T> JsonResult<T> successMsg(T t, ResultCode resultCode) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode(resultCode.SUCCESS.getCode());
        result.setMsg(resultCode.SUCCESS.getMsg());
        result.setData(t);
        log.info("封装返回工具类返回数据为,{}", result.toString());
        return result;
    }



    //失败，返回失败信息
    public static <T> JsonResult<T> failed(ResultCode code) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }


    //失败，返回失败信息
    public static <T> JsonResult<T> customizeFailed(Integer code, String msg) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    //失败，返回失败信息
    public static <T> JsonResult<T> failedAndData(T t, ResultCode code) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        result.setData(t);
        return result;
    }



    //成功，返回数据
    public static <T> StoreJsonResult<T> storeSuccess(T t, ResultCode resultCode) {
        StoreJsonResult<T> result = new StoreJsonResult<T>();
        result.setStatus(resultCode.getCode());
        result.setMessage(resultCode.getMsg());
        result.setData(t);
        log.info("封装返回工具类返回数据为,{}", result);
        return result;
    }


    //失败，返回失败信息
    public static <T> StoreJsonResult<T>  storeFailedAndMsg(Integer code, String msg) {
        StoreJsonResult<T> result = new StoreJsonResult<T>();
        result.setStatus(code);
        result.setMessage(msg);
        return result;
    }
}

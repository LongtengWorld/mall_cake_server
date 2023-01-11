package com.junbaobao.mall.util.exception;

import lombok.Data;

/**
 * @Classname ExceptionRun
 * @Description
 * @Date: Created in 2022/7/21 11:20
 * @Author Name:  junbaobao
 * @Version: 1.0
 */
public class ExceptionRun extends RuntimeException{
    private Integer code;

    public ExceptionRun() {
    }

    public ExceptionRun(String msg) {
        super(msg);
        this.code = 500;
    }

    public ExceptionRun(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

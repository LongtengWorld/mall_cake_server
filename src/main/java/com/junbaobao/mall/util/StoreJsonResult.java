package com.junbaobao.mall.util;


import lombok.Data;

import java.io.Serializable;


public class StoreJsonResult<T> implements Serializable {
    private Integer status;
    private String message;
    private T data;

    public StoreJsonResult() {
    }

    public StoreJsonResult(Integer code, String msg, T obj) {
        this.status = code;
        this.message = msg;
        this.data = obj;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

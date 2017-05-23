package com.llj.demo.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by liulj on 2017/5/1.
 */
public class BaseResponse<T> {
    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private Integer status;

    @Getter
    @Setter
    private T data;

    public BaseResponse(T entity) {
        this.data = entity;
        this.status = 1;
        this.message = "OK";
    }

    public BaseResponse(T entity, int status, String message) {
        this.data = entity;
        this.status = status;
        this.message = message;
    }

    public BaseResponse(T entity, ResponseCode code) {
        this.data = entity;
        this.status = code.getStatus();
        this.message = code.getMessage();
    }
}

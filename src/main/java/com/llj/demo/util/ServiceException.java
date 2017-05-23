package com.llj.demo.util;

import com.llj.demo.response.ResponseCode;

/**
 * Created by liulj on 2017/5/20.
 */
public class ServiceException extends RuntimeException {
    ResponseCode code;

    public ServiceException(ResponseCode code){
        super();
        this.code = code;
    }

    public ServiceException(ResponseCode code, String message){
        super(message);
        this.code = code;
    }

    public ResponseCode getCode() { return this.code; }
}


package com.llj.demo.response;

/**
 * Created by liulj on 2017/5/1.
 */
public enum ResponseCode {
    SUCCESS(1, "OK"),
    PARAM_ERROR(97, "请求参数错误"),
    SYSTEM_EXCEPTION(98, "系统处理异常"),
    SERVICE_EXCEPTION(99, "业务处理异常"),

    //100用户相关
    USER_DOES_NOT_EXIST(100, "用户不存在"),
    PASSWORD_ERROR(101, "密码错误"),
    THE_PHONE_NUMBER_HAS_BEEN_REGISTERED(102, "手机号已经被注册"),
    REGISTER_SUCCESS(1, "注册成功"),
    LOGIN_SUCCESS(1, "登陆成功");

    private final int status;
    private final String message;

    ResponseCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}


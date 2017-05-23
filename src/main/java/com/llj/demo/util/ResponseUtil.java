package com.llj.demo.util;

import com.llj.demo.response.BaseResponse;
import com.llj.demo.response.ResponseCode;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity ok(T entity) {
        return ResponseEntity.ok(new BaseResponse<>(entity));
    }

    public static <T> ResponseEntity genResponse(T entity, Integer status, String message) {
        return ResponseEntity.ok(new BaseResponse<>(entity, status, message));
    }

    public static <T> ResponseEntity genResponse(T entity, ResponseCode code) {
        return ResponseEntity.ok(new BaseResponse<>(entity, code.getStatus(), code.getMessage()));
    }

    public static ResponseEntity genResponse(ResponseCode code) {
        return ResponseEntity.ok(new BaseResponse<>(null, code.getStatus(), code.getMessage()));
    }
}

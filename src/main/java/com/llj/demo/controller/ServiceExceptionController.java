package com.llj.demo.controller;

import com.llj.demo.response.ResponseCode;
import com.llj.demo.util.ResponseUtil;
import com.llj.demo.util.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by liulj on 2017/5/20.
 */
@ControllerAdvice(basePackages = "com.llj.demo.controller")
@Slf4j
public class ServiceExceptionController {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity processServiceException(ServiceException e) {
        return ResponseUtil.genResponse(e.getCode());
    }

}

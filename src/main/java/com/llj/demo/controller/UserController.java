package com.llj.demo.controller;

import com.llj.demo.param.LoginParam;
import com.llj.demo.param.RegisterParam;
import com.llj.demo.po.UserInfoPO;
import com.llj.demo.response.ResponseCode;
import com.llj.demo.service.UserService;
import com.llj.demo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关
 * Created by liulj on 2017/5/1.
 */
@Controller("loginControllerV2")
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody RegisterParam param) {
        param.setLoginType(RegisterParam.TYPE_MOBILE);
        userService.register(param);
        return ResponseUtil.genResponse(param.getUserId(), ResponseCode.REGISTER_SUCCESS);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginParam param) {
        UserInfoPO userInfoPO = userService.login(param);
        return ResponseUtil.genResponse(userInfoPO,ResponseCode.LOGIN_SUCCESS);
    }
}

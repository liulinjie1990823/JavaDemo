package com.llj.demo.param;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by liulj on 2017/5/1.
 */
@Data
public class LoginParam {
    private String mobile;//手机号
    private String password;//密码
}

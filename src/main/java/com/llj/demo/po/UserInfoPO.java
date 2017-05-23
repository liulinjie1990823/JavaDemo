package com.llj.demo.po;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by liulj on 2017/5/1.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoPO {
    public int userId;
    public String userName;
    public String nickName;
    public String gender;
    public Long birthday;
    public String headerUrl;
    public String mobile;
    public int loginType;
    public String password;
}

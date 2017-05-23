package com.llj.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by liulj on 2017/5/1.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoDTO {
    public long userId;
    public String user_name;
    public long birthday;
    public String sex;
    public String mobile;
    public String email;
    public String note;
}

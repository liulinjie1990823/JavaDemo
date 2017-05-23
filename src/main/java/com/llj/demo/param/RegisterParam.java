package com.llj.demo.param;

import lombok.Data;

/**
 * Created by liulj on 2017/5/19.
 */
@Data
public class RegisterParam {
    public final static int TYPE_MOBILE = 0;
    public final static int TYPE_WECHAT = 1;
    public final static int TYPE_QQ = 2;
    public final static int TYPE_SINA = 3;

    private String userId;
    private String userName;
    private String mobile;
    private String password;
    private int loginType;//


}

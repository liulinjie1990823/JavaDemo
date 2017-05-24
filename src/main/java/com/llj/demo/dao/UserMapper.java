package com.llj.demo.dao;

import com.llj.demo.param.LoginParam;
import com.llj.demo.param.RegisterParam;
import com.llj.demo.po.UserInfoPO;
import org.springframework.stereotype.Repository;

/**
 * Created by liulj on 2017/5/1.
 */
@Repository
public interface UserMapper {

    UserInfoPO getUserInfoPO(String mobile);

    int insert(RegisterParam registerParam);
}

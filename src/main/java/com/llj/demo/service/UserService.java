package com.llj.demo.service;

import com.llj.demo.dao.UserMapper;
import com.llj.demo.param.LoginParam;
import com.llj.demo.param.RegisterParam;
import com.llj.demo.po.UserInfoPO;
import com.llj.demo.response.ResponseCode;
import com.llj.demo.util.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 用户业务
 * Created by liulj on 2017/5/1.
 */
@Slf4j
@Service
public class UserService extends BaseService {

    @Autowired
    private UserMapper userMapper;

    private void checkRegisterParam(RegisterParam param) {
        if (param == null
                || StringUtils.isEmpty(param.getMobile())
                || StringUtils.isEmpty(param.getPassword())) {
            throw new ServiceException(ResponseCode.PARAM_ERROR);
        }
    }

    public int register(RegisterParam param) {
        checkRegisterParam(param);

        UserInfoPO userInfoPO = userMapper.getUserInfoPO(param.getMobile());
        if (userInfoPO != null) {
            throw new ServiceException(ResponseCode.THE_PHONE_NUMBER_HAS_BEEN_REGISTERED);
        }

        return userMapper.insert(param);
    }

    private void checkLoginParam(LoginParam param) {
        if (param == null
                || StringUtils.isEmpty(param.getMobile())
                || StringUtils.isEmpty(param.getPassword())) {
            throw new ServiceException(ResponseCode.PARAM_ERROR);
        }
    }

    public UserInfoPO login(LoginParam param) {
        checkLoginParam(param);

        UserInfoPO userInfoPO = userMapper.getUserInfoPO(param.getMobile());
        if (userInfoPO == null) {
            throw new ServiceException(ResponseCode.USER_DOES_NOT_EXIST);
        }
        if (!param.getPassword().equals(userInfoPO.getPassword())) {
            throw new ServiceException(ResponseCode.PASSWORD_ERROR);
        }
        return userInfoPO;
    }


}

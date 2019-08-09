package com.ril.rilcompany.service.impl;

import com.ril.rilcompany.exception.BusinessException;
import com.ril.rilcompany.mapper.UserMapper;
import com.ril.rilcompany.model.UserModel;
import com.ril.rilcompany.service.UserService;
import com.ril.rilcompany.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;

/**
 * Classname UserServiceImpl
 * Description 用户服务接口实现类
 * Date 8/8/19 1:59 PM
 * Created by rnd
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel getUser(String email,String password) {
        if(StringUtils.isBlank(email) || StringUtils.isBlank(password)){
            throw BusinessException.withErrorCode(StatusCode.User.EMAIL_PASSWORD_EMPTY);
        }
        UserModel user = userMapper.getUser(email,password);
        if(null == user){
            throw BusinessException.withErrorCode(StatusCode.User.EMAIL_PASSWORD_ERROR);
        }
        return user;
    }

    @Override
    public int addUser(Map<String, Object> params) {
        return userMapper.addUser(params);
    }


    @Override
    public int queryUser(String email) {
        UserModel user = userMapper.queryUser(email);
        if(user!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public int updateUser(UserModel user) {
        if(null==user){
            throw BusinessException.withErrorCode(StatusCode.System.PARAM_ERROR);
        }
        return userMapper.updateUser(user);
    }


    @Override
    public int deleteUser(Integer userid) {
        if(null == userid){
            throw BusinessException.withErrorCode(StatusCode.System.PARAM_ERROR);
        }
        return userMapper.deleteUser(userid);
    }


}

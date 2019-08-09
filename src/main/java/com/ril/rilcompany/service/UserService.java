package com.ril.rilcompany.service;

import com.ril.rilcompany.model.UserModel;

import java.util.Map;

/**
 * Classname UserService
 * Description 用户服务
 * Date 8/8/19 1:59 PM
 * Created by rnd
 */
public interface UserService {

    /**
     * User Login
     * @param email
     * @param password
     * @return UserModel
     */
    UserModel getUser(String email,String password);


    /**
     * 添加用户信息
     * @param params
     * @return
     */
    int addUser(Map<String,Object> params);


    /**
     * 查询是否有相同的用户 以及找回密码 需要此接口
     * @param phone
     * @return
     */
    int queryUser(String phone);


    /**
     * 更新用户信息
     * @param user
     * @return number
     */
    int updateUser(UserModel user);


    /**
     * 删除用户信息
     * @param userid
     * @return number
     */
    int deleteUser(Integer userid);



}

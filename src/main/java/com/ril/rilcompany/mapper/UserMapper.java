package com.ril.rilcompany.mapper;

import com.ril.rilcompany.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

/**
 * Classname UserMapper
 * Description TODO
 * Date 8/8/19 2:03 PM
 * Created by rnd
 */

@Mapper
public interface UserMapper {
    /**
     * 获取账号和密码
     * @param email
     * @param password
     * @return UserModel
     */
    UserModel getUser(String email,String password);


    /**
     * 添加用户的接口
     * @param params
     * @return number
     */
    int addUser(Map<String,Object> params);


    /**
     * 查询用户是否存在相同的用户名
     * @param email
     * @return UserModel
     */
    UserModel queryUser(@Param("email") String email);


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
    int deleteUser(@Param("userid") Integer userid);








}

package com.ril.rilcompany.domain.user;

/**
 * Classname RegUserReq
 * Description 注册用户
 * Date 8/8/19 2:10 PM
 * Created by rnd
 */
public class RegUserReq {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // 用户邮箱
    private String email;
    // 用户密码
    private String password;
    // 注册用户名字
    private String username;
}

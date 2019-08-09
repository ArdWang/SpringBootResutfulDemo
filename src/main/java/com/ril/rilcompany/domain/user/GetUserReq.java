package com.ril.rilcompany.domain.user;


import com.ril.rilcompany.base.BaseReq;

/**
 * Classname GetUserReq
 * Description 用户登录接收数据Request
 * Date 5/28/19 10:01 AM
 * Created by rnd
 */
public class GetUserReq extends BaseReq {

    private String email;

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

    private String password;

}

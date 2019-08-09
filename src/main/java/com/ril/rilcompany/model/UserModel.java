package com.ril.rilcompany.model;

import org.springframework.context.annotation.Bean;

/**
 * Classname UserModel
 * Description user模型
 * Date 8/8/19 2:00 PM
 * Created by rnd
 */


public class UserModel {

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    private String userid;

    private String usercode;

    private String email;

    private String password;

    private String username;

    private String sex;

    private String isadmin;
}

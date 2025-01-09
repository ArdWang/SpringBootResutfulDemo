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

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
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

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    private String userid;

    private String userphone;

    private String useremail;

    private String password;

    private String username;

    private String usersex;

}

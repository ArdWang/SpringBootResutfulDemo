package com.ril.rilcompany.domain.user;

/**
 * @Classname UpdUserReq
 * @Description 更新用户信息
 * @Date 8/9/19 3:49 PM
 * @Created by rnd
 */
public class UpdUserReq {

    private String userid;

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

    private String usercode;

    private String email;

    private String password;

    private String username;

    private String sex;

    private String isadmin;

}

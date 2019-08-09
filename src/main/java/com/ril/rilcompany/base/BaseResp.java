package com.ril.rilcompany.base;

import java.io.Serializable;

/**
 * Classname BaseResp
 * Description 基类返回数据
 * Date 5/28/19 9:58 AM
 * Created by rnd
 */
public class BaseResp<T> implements Serializable{

    public BaseResp(){

    }

    public BaseResp(String code){
        this.code = code;
    }

    public BaseResp(String code, T data){
        this.code = code;
        this.data = data;
    }

    public BaseResp(String code, String msg){
        this.code = code;
        this.message = msg;
    }

    public BaseResp(String code,T data ,String msg){
        this.code = code;
        this.data = data;
        this.message = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String code;
    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;
}

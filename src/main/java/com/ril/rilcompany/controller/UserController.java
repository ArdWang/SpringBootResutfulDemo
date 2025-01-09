package com.ril.rilcompany.controller;

import com.ril.rilcompany.base.BaseController;
import com.ril.rilcompany.base.BaseResp;
import com.ril.rilcompany.domain.user.DelUserReq;
import com.ril.rilcompany.domain.user.GetUserReq;
import com.ril.rilcompany.domain.user.RegUserReq;
import com.ril.rilcompany.domain.user.UpdUserReq;
import com.ril.rilcompany.model.UserModel;
import com.ril.rilcompany.service.UserService;
import com.ril.rilcompany.utils.MD5Util;
import com.ril.rilcompany.utils.RandomChar;
import com.ril.rilcompany.utils.StatusCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Classname UserController
 * Description 用户Controller
 * Date 8/8/19 2:12 PM
 * Created by rnd
 */


@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/user"})
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    //信息打印Log4j
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 得到用户信息
     * 只能通过Post接收传递的数据
     * ResponseBody是用于构建RESTFUL api的
     */
    @RequestMapping(value = {"/getUser"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<UserModel> getUser(@RequestBody GetUserReq req){
        BaseResp resp = new BaseResp();
        try{
            String email = req.getEmail();
            String password = req.getPassword();

            //检查不能为空值 空值就为错误
            if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
                resp.setCode(StatusCode.Code.CODE_ERROR);
                resp.setMessage("输入不能为空");
                return resp;
            }

            String md5Pwd = MD5Util.MD5EncodeUtf8(password);
            UserModel user = userService.getUser(email, md5Pwd);

            if(user==null){
                resp.setCode(StatusCode.Code.CODE_ERROR);
                resp.setMessage("帐号或者密码错误");
                return resp;
            }

            resp.setCode(StatusCode.Code.CODE_SUCCESS);
            resp.setMessage("获取成功");
            resp.setData(user);
            return resp;


        }catch (Exception e){
            return getBaseResp(logger,resp, e);
        }
    }


    /**
     * 注册用户
     * @param req
     * @return resp
     */
    @RequestMapping(value = {"/regUser"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp regUser(@RequestBody RegUserReq req){
        BaseResp resp = new BaseResp();

        try{
            String email = req.getEmail();
            String password =req.getPassword();
            String username = req.getUsername();

            if(StringUtils.isBlank(email)||StringUtils.isBlank(password)||
                    StringUtils.isBlank(username)){
                resp.setCode(StatusCode.Code.CODE_ERROR);
                resp.setMessage("参数不能为空");
                return resp;
            }

            int queryUser = userService.queryUser(email);

            if(queryUser>0){
                resp.setCode(StatusCode.Code.CODE_ERROR);
                resp.setMessage("该邮箱已被注册");
                return resp;
            }

            String md5Pwd = MD5Util.MD5EncodeUtf8(password);
            //添加的时候用户名一样的添加
            Map<String, Object> params = new HashMap<>();
            params.put("email", email);
            params.put("password", md5Pwd);
            params.put("username",username);
            params.put("usercode", RandomChar.getRandomChar(20));

            int addUser = userService.addUser(params);

            if(addUser==0){
                resp.setCode(StatusCode.Code.CODE_ERROR);
                resp.setMessage("用户注册失败");
                return resp;
            }

            resp.setCode(StatusCode.Code.CODE_SUCCESS);
            resp.setMessage("用户注册成功");
            return resp;

        }catch (Exception e){
            return getBaseResp(logger,resp, e);
        }
    }



    @RequestMapping(value = {"/editUser"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp editUser(@RequestBody UpdUserReq req){
        BaseResp resp = new BaseResp();
        try{
            //传入的3个参数不能为空
            if(StringUtils.isBlank(req.getUserid())||StringUtils.isBlank(req.getEmail())||
                    StringUtils.isBlank(req.getUsercode())){
                resp.setCode(StatusCode.Code.CODE_ERROR);
                resp.setMessage("参数不能为空");
                return resp;
            }

            UserModel user = new UserModel();
            user.setUserid(req.getUserid());
            user.setPassword(req.getPassword());
            user.setUseremail(req.getEmail());
            user.setPassword(req.getPassword());
            user.setUsersex(req.getSex());

            int edit = userService.updateUser(user);

            if(0==edit){
                resp.setCode(StatusCode.Code.CODE_ERROR);
                resp.setMessage("信息更新失败");
                return resp;
            }

            resp.setCode(StatusCode.Code.CODE_SUCCESS);
            resp.setMessage("信息更新成功");
            return resp;

        }catch (Exception e){
            return getBaseResp(logger,resp,e);
        }
    }


    @RequestMapping(value = {"/delUser"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp editUser(@RequestBody DelUserReq req){
        BaseResp resp = new BaseResp();
        try{
            //传入的3个参数不能为空
            if(StringUtils.isBlank(req.getUserid())){
                resp.setCode(StatusCode.Code.CODE_ERROR);
                resp.setMessage("参数不能为空");
                return resp;
            }

            Integer userid = Integer.parseInt(req.getUserid());
            int del = userService.deleteUser(userid);

            if(0 == del){
                resp.setCode(StatusCode.Code.CODE_ERROR);
                resp.setMessage("用户信息删除失败");
                return resp;
            }

            resp.setCode(StatusCode.Code.CODE_SUCCESS);
            resp.setMessage("用户信息删除成功");
            return resp;

        }catch (Exception e){
            return getBaseResp(logger,resp,e);
        }
    }

}

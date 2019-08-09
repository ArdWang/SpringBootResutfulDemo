package com.ril.rilcompany.base;

import com.ril.rilcompany.utils.StatusCode;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Classname BaseController
 * @Description Base基础类
 * @Date 8/8/19 1:50 PM
 * @Created by rnd
 */
public class BaseController {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    /**
     * 公共处理返回类
     * @param resp
     * @param e
     * @return
     */
    protected BaseResp getBaseResp(Logger logger, BaseResp resp, Exception e) {
        logger.error("User Error:",e);
        resp.setCode(StatusCode.Code.CODE_SERVER_ERROR);
        resp.setMessage("服务器错误");
        return resp;
    }

}

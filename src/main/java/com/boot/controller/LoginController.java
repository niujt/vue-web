package com.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.Common.CommonStatus;
import com.boot.entity.Login;
import com.boot.service.LoginService;
import com.boot.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private LoginService service;
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String username;
    /**
     * 登录
     * @param username 账号
     * @param password 密码
     * @param session session
     * @return 登录状态码
     */
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public JSONObject login(@RequestParam("username") String username, @RequestParam("password") String password,HttpSession session){
        String status=service.login(username,SpringUtils.MD5(password));
        JSONObject json=new JSONObject();
        json.put(CommonStatus.LoginStatus,status);
        if (status=="success"){
            session.setAttribute("login",service.getLogin(username));
        }
        return json;

    }

    /**
     * 登出
     * @param session session
     * @return 登陆状态码
     */
    @RequestMapping(value="loginout",method = RequestMethod.GET)
    public JSONObject loginout(HttpSession session){
        JSONObject json=new JSONObject();
        session.removeAttribute("login");
        json.put(CommonStatus.LoginStatus,CommonStatus.LoginOut);
        return json;
    }

    /**
     * 忘记密码
     * 邮箱获取验证码
     * @param email 收件的邮箱
     * @return 验证码+状态码
     */
    @RequestMapping(value="forgetPwd",method = RequestMethod.PUT)
    public JSONObject forgetPwd(@RequestParam String email,HttpSession session){
        //System.out.println(username);
        //System.out.println(email);
        JSONObject json=new JSONObject();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String code=SpringUtils.getRandomCode(); //随机生成验证码
        simpleMailMessage.setFrom(username);//发送人
        simpleMailMessage.setTo(email);//收件人
        simpleMailMessage.setSubject("重置密码");  //邮箱主题
        simpleMailMessage.setText("您的验证码为:"+code);//邮箱内容 自定义
        javaMailSender.send(simpleMailMessage);
        json.put(CommonStatus.SysStatus,CommonStatus.Success);
        json.put("code",code);
        session.setAttribute("code",code);
        return json;
    }

    /**
     * 修改密码
     * @param login
     * @return
     */
    @RequestMapping(value = "updatePwd",method = RequestMethod.PUT)
    public JSONObject updatePwd(@RequestBody Login login,HttpSession session){
        JSONObject json=new JSONObject();
        String code=(String)session.getAttribute("code");
        if(login.getCode().equals(code)){
            json.put(CommonStatus.LoginStatus,service.updatePassword(login));
        }
       else{
            json.put(CommonStatus.LoginStatus,CommonStatus.Error);
        }
       session.removeAttribute("code");
        return json;
    }
}

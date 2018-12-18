package com.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.Common.CommonStatus;
import com.boot.entity.Login;
import com.boot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private LoginService service;
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public JSONObject login(@RequestParam("username") String username, @RequestParam("password") String password){
        JSONObject json=new JSONObject();
            json.put(CommonStatus.LoginStatus,service.login(username,password));
        return json;

    }
//    @RequestMapping(value="loginout",method = RequestMethod.GET)
//    public JSONObject loginout(HttpSession session){
//        JSONObject json=new JSONObject();
//        session.removeAttribute("login");
//        json.put(CommonStatus.LoginStatus,CommonStatus.LoginStatus2);
//        return json;
//    }

}

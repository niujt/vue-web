package com.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    UserService service;

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping(value= "user",method = RequestMethod.GET)
    public JSONObject getUsers(){
        JSONObject json=new JSONObject();
        json.put("users",service.getUserList());
        //System.out.println(session.getAttribute("login"));
        return json;
    }
}

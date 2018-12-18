package com.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.Common.CommonStatus;
import com.boot.entity.Login;
import com.boot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistController {
    @Autowired
    private LoginService service;
    @RequestMapping(value="regist",method = RequestMethod.PUT)
    public JSONObject regist(@RequestBody Login login){
        JSONObject json=new JSONObject();
        json.put(CommonStatus.RegistStatus,service.regist(login));
        return json;
    }

}

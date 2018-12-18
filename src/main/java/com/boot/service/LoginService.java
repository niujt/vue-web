package com.boot.service;

import com.boot.Common.CommonStatus;
import com.boot.dao.LoginDAO;
import com.boot.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginDAO dao;
    public String login(String username,String password){
        Login login=dao.findUserByUsername(username);
        if(login==null){
            return CommonStatus.LoginError1;
        }
        else if(!password.equals(login.getPassword())){
            return CommonStatus.LoginError2;
        }
        return CommonStatus.Success;
    }
    public String regist(Login login){
        Login loginold=dao.findUserByUsername(login.getUsername());
        if(loginold!=null){
            return CommonStatus.RegistError;
        }
        else{
            dao.addLogin(login);
            return CommonStatus.Success;
        }
    }
}

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

    /**
     * 获取登录信息
     * @param username
     * @return
     */
    public Login getLogin(String username){
        return  dao.findUserByUsername(username);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
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

    /**
     * 注册
     * @param login
     * @return
     */
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

    /**
     * 更新密码
     * @param login
     * @return
     */
    public String updatePassword(Login login){
        if(dao.updateLogin(login)>0){
            return CommonStatus.Success;
        }
        else{
            return CommonStatus.Error;
        }
    }
}

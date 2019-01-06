package com.boot.service;

import com.boot.dao.UserDAO;
import com.boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO dao;

    /**
     * 获取用户列表
     * @return
     */
    public List<User> getUserList(){
        return dao.findAll();
    }
    public User getUserByLoginid(Integer id){
        return dao.findUserByLoginid(id);
    }
}

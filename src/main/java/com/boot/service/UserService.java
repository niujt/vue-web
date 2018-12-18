package com.boot.service;

import com.boot.dao.UserDAO;
import com.boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO dao;
    public List<User> getUserList(){
        return dao.findAll();
    }
}

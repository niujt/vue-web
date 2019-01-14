package com.boot.service;

import com.boot.Common.CommonStatus;
import com.boot.dao.UserDAO;
import com.boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userdao;


    /**
     * 获取用户列表
     * @return
     */
    public List<User> getUserList(){
        return userdao.findAll();
    }

    /**
     * 根据登录id获取用户信息
     * @param id
     * @return
     */
    public User getUserByLoginid(Integer id){
        return userdao.findUserByLoginid(id);
    }

    /**
     * 添加用户信息
     * @param loginid
     * @return
     */
    public int addUser(Integer loginid){
        if(userdao.findUserByLoginid(loginid)==null){
            return userdao.addUser(loginid);
        }
        else{
           return 0;
        }

    }

    /**
     * 更新基本信息
     * @param user
     * @return
     */
    public String UpdateUser1(User user){
        return userdao.updateUser1(user)>0? CommonStatus.Success:CommonStatus.Error;
    }

    /**
     * 更新头像
     * @param user
     * @return
     */
    public String UpdateUser2(User user){
        return userdao.updateUser2(user)>0? CommonStatus.Success:CommonStatus.Error;
    }

    /**
     * 更新学历
     * @param user
     * @return
     */
    public String UpdateUser3(User user){
        return userdao.updateUser3(user)>0? CommonStatus.Success:CommonStatus.Error;
    }
}

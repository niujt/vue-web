package client.service;

import client.dao.UserDAO;
import com.vue.entity.User;
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
     * @param user
     * @param id
     * @return
     */
    public int addUser(User user,Integer id){
        if(id==null){
            return userdao.addUser(user);
        }
        else{
           return 0;
        }

    }
}

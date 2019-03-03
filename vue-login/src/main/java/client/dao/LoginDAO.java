package client.dao;

import com.vue.entity.Login;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginDAO {
    /**
     * 根据账号查询登录信息
     * @param username
     * @return
     */
    @Select("select * from login where username=#{username}")
    Login findUserByUsername(@Param("username") String username);

    /**
     * 添加登录信息
     * @param login
     * @return
     */
    @Insert("insert into login(username,password) values(#{username},#{password})")
    int addLogin(Login login);

    /**
     * 更新登录信息
     * @param login
     * @return
     */
    @Update("update login set password=#{password} where username=#{username}")
    int updateLogin(Login login);

}

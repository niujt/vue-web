package com.boot.dao;

import com.boot.entity.Login;
import com.boot.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginDAO {
    @Select("select * from login where username=#{username}")
    Login findUserByUsername(@Param("username") String username);
    @Insert("insert into login(username,password) values(#{username},#{password})")
    int addLogin(Login login);
    @Update("update login set password=#{password} where username=#{username}")
    int updateLogin(Login login);

}

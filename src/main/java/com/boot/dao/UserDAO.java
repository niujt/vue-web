package com.boot.dao;

import com.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDAO {
    /**
     * 查询用户信息列表
     * @return
     */
    @Select("select *,getDeptPosition(deptpositionid) as deptposition,getAddress(addressid) as address from user")
    List<User> findAll();

    /**
     * 更具登录id查询用户信息
     * @param id
     * @return
     */
    @Select("select *,getDeptPosition(deptpositionid) as deptposition,getAddress(addressid) as address from user where loginid=#{loginid}")
    User findUserByLoginid(Integer id);
}

package com.boot.dao;

import com.boot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /**
     * 用户基本信息页面更新
     * @param user
     * @return
     */
    @Update("update user " +
            "set name=#{name},phone=#{phone},age=#{age},deptpositionid=#{deptpositionid},sex=#{sex},addressid=#{addressid} " +
            "where id=#{id}")
    int updateUser1(User user);

    /**
     * 用户教育信息页面更新
     * @param user
     * @return
     */
    @Update("update user " +
            "set education1=#{education1},education2=#{education2},education3=#{education3},education4=#{education4},ishigheducation=#{ishigheducation}" +
            "where id=#{id}")
    int updateUser2(User user);
    /**
     * 更新用户头像
     * @param user
     * @return
     */
    @Update("update user " +
            "set iconhead=#{iconhead}" +
            "where id=#{id}")
    int updateUser3(User user);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @Insert("insert into user " +
            "values(#{loginid},#{name},#{iconhead},#{email},#{phone},#{sex},#{age},#{salary}" +
            ",#{education1},#{education2},#{education3},#{education4}" +
            ",#{ishigheducation},#{deptpositionid},#{addressid},now())")
    int addUser(User user);
}

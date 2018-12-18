package com.boot.dao;

import com.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDAO {
    @Select("select " +
            "u.id as id,u.name as name,u.age as age,u.salary as salary,concat(c.name,c.state) as address " +
            "from user u,city c " +
            "where u.addressid=c.id")
    List<User> findAll();

}

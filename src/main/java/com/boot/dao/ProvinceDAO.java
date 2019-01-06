package com.boot.dao;

import com.boot.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProvinceDAO {
    @Select("select * from province")
    public List<Province> findAll();
}

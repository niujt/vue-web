package com.boot.dao;

import com.boot.entity.City;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CityDAO {
    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(1) from city")
    int getCount();

    /**
     * 查询所有城市记录
     * @return
     */
    @Select("select * from city")
    List<City> findAll();

    /**
     * 根据id查找城市信息
     * @param id
     * @return
     */
    @Select("select * from city where id=#{id}")
    City findById(Integer id);

    /**
     * 添加城市信息
     * @param city
     * @return
     */
    @Insert("insert into city(name,state) values(#{name},#{state})")
    int addCity(City city);

    /**
     * 更新城市信息
     * @param city
     * @return
     */
    @Update("update city set name=#{name},state=#{state} where id=#{id}")
    int updateCityById(City city);

    /**
     * 删除城市信息
     * @param id
     * @return
     */
    @Delete("delete from city where id=#{id}")
    int deleteCityByid(Integer id);
}

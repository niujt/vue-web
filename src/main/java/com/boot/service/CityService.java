package com.boot.service;

import com.boot.dao.CityDAO;
import com.boot.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityDAO dao;

    /**
     * 城市信息记录数
     * @return
     */
    public int getCount(){return dao.getCount();}

    /**
     * 城市信息列表
     * @return
     */
    public List<City> getCityList() {
        return dao.findAll();
    }

    /**
     * 添加城市
     * @param city
     * @return
     */
    public int addCity(City city){
        return dao.addCity(city);
    }

    /**
     * 更新城市
     * @param city
     * @return
     */
    //@CachePut(value = "city", key = "#root.args[0]", unless = "#city eq null ")
    public boolean updateCity(City city){
        return dao.updateCityById(city)!=0;
    }

    /**
     * 删除城市
     * @param id
     * @return
     */
    //@CacheEvict(value = "city", key = "#root.args[0]", condition = "#result eq true")
    public boolean deleteCity(Integer id){
        return dao.deleteCityByid(id)!=0;
    }

    /**
     * 根据id查询城市
     * @param id
     * @return
     */
    //@Cacheable(value = "city", key = "#root.args[0]", unless = "#result eq null ")
    public City findOne(Integer id){
        return dao.findById(id);
    }
}

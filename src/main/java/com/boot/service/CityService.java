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
    public int getCount(){return dao.getCount();}
    public List<City> getCityList() {
        return dao.findAll();
    }
    public int addCity(City city){
        return dao.addCity(city);
    }
    public boolean updateCity(City city){
        return dao.updateCityById(city)!=0;
    }
    public boolean deleteCity(Integer id){
        return dao.deleteCityByid(id)!=0;
    }
    public City findOne(Integer id){
        return dao.findById(id);
    }
}

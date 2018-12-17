package com.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.Common.CommonStatus;
import com.boot.entity.City;
import com.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService service;
    @RequestMapping(value = "city",method = RequestMethod.GET)
    public JSONObject getCityList(){
       List<City> citys=service.getCityList();
       JSONObject json=new JSONObject();
       json.put("citys",citys);
       return json;
    }
    @RequestMapping(value = "city",method = RequestMethod.POST)
    public JSONObject addCity(@RequestBody City city){
        JSONObject json=new JSONObject();
            if(service.addCity(city)>0){
                json.put(CommonStatus.CityStatus,CommonStatus.Success);
            }
            else{
                json.put(CommonStatus.CityStatus,CommonStatus.Error);
            }
        return json;
    }
    @RequestMapping(value = "city",method = RequestMethod.PUT)
    public JSONObject updateCity(@RequestBody City city){
        JSONObject json=new JSONObject();
       if(service.updateCity(city))
           json.put(CommonStatus.CityStatus, CommonStatus.Success);

       else
           json.put("CityStatus", CommonStatus.Error);
        return json;
    }
    @RequestMapping(value = "city/{id}",method = RequestMethod.DELETE)
    public JSONObject deleteCity(@PathVariable Integer id){
        JSONObject json=new JSONObject();
        if(service.deleteCity(id))
            json.put(CommonStatus.CityStatus,CommonStatus.Success);
        else
            json.put(CommonStatus.CityStatus,CommonStatus.Error);
        return json;
    }
    @RequestMapping(value = "city/{id}",method = RequestMethod.GET)
    public JSONObject getCity(@PathVariable Integer id){
        City city=service.findOne(id);
        JSONObject json=new JSONObject();
        json.put("city",city);
        return json;
    }
}

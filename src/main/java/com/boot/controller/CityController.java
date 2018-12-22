package com.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.Common.CommonStatus;
import com.boot.entity.City;
import com.boot.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    private static Logger logger= LoggerFactory.getLogger(CityController.class);
    @Autowired
    private CityService service;

    /**
     * 获取城市列表
     * @return
     */
    @RequestMapping(value = "city",method = RequestMethod.GET)
    public JSONObject getCityList(){
        List<City> citys=service.getCityList();
       JSONObject json=new JSONObject();
       json.put("citys",citys);
       json.put("count",service.getCount());
       return json;
    }

    /**
     * 添加城市
     * @param city
     * @return
     */
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

    /**
     * 修改城市
     * @param city
     * @return
     */
    @RequestMapping(value = "city",method = RequestMethod.PUT)
    public JSONObject updateCity(@RequestBody City city){
        JSONObject json=new JSONObject();
       if(service.updateCity(city))
           json.put(CommonStatus.CityStatus, CommonStatus.Success);

       else
           json.put("CityStatus", CommonStatus.Error);
        return json;
    }

    /**
     * 删除城市
     * @param id
     * @return
     */
    @RequestMapping(value = "city/{id}",method = RequestMethod.DELETE)
    public JSONObject deleteCity(@PathVariable Integer id){
        JSONObject json=new JSONObject();
        if(service.deleteCity(id))
            json.put(CommonStatus.CityStatus,CommonStatus.Success);
        else
            json.put(CommonStatus.CityStatus,CommonStatus.Error);
        return json;
    }

    /**
     * 根据id查找城市
     * @param id
     * @return
     */
    @RequestMapping(value = "city/{id}",method = RequestMethod.GET)
    public JSONObject getCity(@PathVariable Integer id){
        City city=service.findOne(id);
        JSONObject json=new JSONObject();
        json.put("city",city);
        return json;
    }
}

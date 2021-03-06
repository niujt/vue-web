package com.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.Common.CommonStatus;
import com.boot.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvinceController {
    @Autowired
    ProvinceService service;

    /**
     * 获取所有省份信息
     * @return
     */
    @RequestMapping(value = "/province",method = RequestMethod.GET)
    public JSONObject getProvinceList(){
        JSONObject json=new JSONObject();
        json.put(CommonStatus.ProvinceStatus,service.getProvinceList());
        return json;

    }
}

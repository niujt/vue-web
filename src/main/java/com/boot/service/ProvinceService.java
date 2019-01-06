package com.boot.service;

import com.boot.dao.ProvinceDAO;
import com.boot.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    ProvinceDAO dao;
    public List<Province> getProvinceList(){
        return dao.findAll();
    }
}

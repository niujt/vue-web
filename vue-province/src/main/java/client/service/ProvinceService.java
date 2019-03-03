package client.service;

import client.dao.ProvinceDAO;
import com.vue.entity.Province;
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

package com.test;

import com.boot.APPStart;
import com.boot.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = APPStart.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCase {
    @Autowired
    private CityService service;

    @Test
    public void test1(){
        System.out.println(service.findOne(1));
       //city.setCityname("111");
       // service.updateCity(city);
      // System.out.println(city+"修改1");
       // System.out.println(city+"2222");
       // service.deleteCity(1);
       // System.out.println(service.findOne(1));
    }
}

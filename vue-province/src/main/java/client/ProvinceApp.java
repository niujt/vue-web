package client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.client.dao")
public class ProvinceApp {
    public static void main(String[] args){
        SpringApplication.run(ProvinceApp.class,args);
    }
}

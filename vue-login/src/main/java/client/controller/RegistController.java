package client.controller;

import client.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import com.vue.common.CommonStatus;
import com.vue.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistController {
    @Autowired
    private LoginService service;

    /**
     * 注册
     * @param login
     * @return
     */
    @RequestMapping(value="regist",method = RequestMethod.PUT)
    public JSONObject regist(@RequestBody Login login){
        JSONObject json=new JSONObject();
        json.put(CommonStatus.RegistStatus,service.regist(login));
        return json;
    }

}

package client.controller;

import com.alibaba.fastjson.JSONObject;
import com.vue.entity.Login;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class IndexController {
    /**
     * 获取登录信息，包括用户名，登录id
     * @return
     */
    @RequestMapping(value="logininfo",method = RequestMethod.GET)
    public JSONObject logininfo(HttpSession session){
        Login login=(Login)session.getAttribute("login");
        JSONObject json=new JSONObject();
        json.put("logininfo",login);
        return json;
    }
}

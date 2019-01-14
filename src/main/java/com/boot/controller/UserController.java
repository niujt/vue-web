package com.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.Common.CommonStatus;
import com.boot.entity.User;
import com.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class UserController {
    private static Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService service;

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping(value= "user",method = RequestMethod.GET)
    public JSONObject getUsers(){
        JSONObject json=new JSONObject();
        json.put("users",service.getUserList());
        return json;
    }

    /**
     * 上传头像
     * @return
     */
    @RequestMapping(value = "userUpload",method =RequestMethod.POST)
    public JSONObject userUpload(@RequestBody MultipartFile file, HttpServletRequest request){
        JSONObject json=new JSONObject();
        System.out.println("上传图片是否为空："+file.isEmpty());
        try{
            if(file != null){
                String path =null;// 文件路径
                String imgType=null;//图片类型
                String  fileName = file.getOriginalFilename();// 原文件名称
                // 判断图片类型
                imgType=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
                if(imgType!=null){
                    if("GIF".equals(imgType.toUpperCase()) || "PNG".equals(imgType.toUpperCase()) || "JPG".equals(imgType.toUpperCase())){
                        //String realPath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/imgupload/";
                        // 自定义的文件名称
                        String trueFileName=String.valueOf(System.currentTimeMillis())+".jpg";
                        // 设置图片存放的路径
                       // path=realPath+trueFileName;
                        logger.info("图片的存放路径为"+path);
                        // 转存文件到指定路径
                        file.transferTo(new File(path)); // 转存而不是写出
                        logger.info("文件成功上传到指定目录下");
                    }else{
                        logger.info("请上传GIF、PNG或者JPG格式的文件");
                    }
                }else{
                    logger.info("文件类型为空");
                }
            }else{
                logger.info("没有找到相对应的文件");
            }
            logger.info("文件上传的原名称为:"+file.getOriginalFilename());
            logger.info("上传成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 根据登录id获取用户信息,
     * 当登录id不存在对应的用户信息时，则新增空白用户信息
     * @param loginid
     * @return
     */
    @RequestMapping(value="user1/{loginid}",method = RequestMethod.GET)
    public JSONObject getUserByLogin(@PathVariable Integer loginid){
        JSONObject json=new JSONObject();
        json.put(CommonStatus.LoginUserStatus,service.getUserByLoginid(loginid));
        if(service.getUserByLoginid(loginid)==null){
            json.put(CommonStatus.UserStatus, service.addUser(loginid)!=0?CommonStatus.Success:CommonStatus.Error);
        }
        return json;
    }

    /**
     * 更新用户的基本信息
     * @param user
     * @return
     */
    @RequestMapping(value="userup1",method = RequestMethod.PUT)
    public JSONObject userup1(@RequestBody User user){
        JSONObject json=new JSONObject();
        json.put(CommonStatus.UserStatus,service.UpdateUser1(user));
        return json;
    }
    /**
     *  更新用户头像
     * @param user
     * @return
     */
//    @RequestMapping(value="userup2",method = RequestMethod.PUT)
//    public JSONObject userup2(@RequestBody User user){
//        JSONObject json=new JSONObject();
//        json.put(CommonStatus.UserStatus,service.UpdateUser2(user));
//        return json;
//    }

    /**
     * 更新用户的学历
     * @param user
     * @return
     */
    @RequestMapping(value="userup3",method = RequestMethod.PUT)
    public JSONObject userup3(@RequestBody User user){
        JSONObject json=new JSONObject();
        json.put(CommonStatus.UserStatus,service.UpdateUser3(user));
        return json;
    }
}

package com.vue.utils;

import org.apache.commons.codec.digest.DigestUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 项目工具类
 */
public class SpringUtils {
    /**
     * 随机生成验证码
     * @return 验证码
     */
    public static String getRandomCode(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<4;i++){
           sb.append(new Random().nextInt(10)+"");
        }
    return sb.toString();

    }

    /**
     * md5加密
     * @param data
     * @return
     */
    public static String MD5(String data){
        return DigestUtils.md5Hex(data);
    }
   public static String Date2String(Date date){
       SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/dd");
       return sdf.format(date);
   }
//    public static void main(String[] args){
//       System.out.println(MD5("123456"));
//    }
}

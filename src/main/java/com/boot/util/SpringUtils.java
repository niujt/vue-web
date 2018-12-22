package com.boot.util;

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
//    public static void main(String[] args){
//       System.out.println(SpringUtils.getRandomCode());
//    }
}

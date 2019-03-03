package com.vue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
@Getter
@Setter
@ToString
public class User {
    /**主键*/
    private Integer id;
    /**姓名*/
    private String name;
    /**头像路径*/
    private String iconheader;
    /**邮箱*/
    private String email;
    /**手机*/
    private String phone;
    /**性别*/
    private int sex;
    /**年龄*/
    private int age;
    /**薪水*/
    private double salary;
    /**小学学历*/
    private String education1;
    /**初中学历*/
    private String education2;
    /**高中学历*/
    private String education3;
    /**大学学历*/
    private String education4;
    /**是否研究生及以上*/
    private Integer ishigheducation;
    /**部门职位id*/
    private Integer deptpositionid;
    /**部门职位*/
    private String deptposition;
    /**地址id*/
    @JsonIgnore
    private Integer addressid;
    /**地址（伪列）*/
    private String address;
    /**创建时间*/
    private Date createtime;
    /**登录id*/
    private Integer loginid;
}

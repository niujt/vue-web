package com.boot.entity;

import com.boot.util.SpringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

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
    @JsonIgnore
    /**创建时间*/
    private Date createtime;
    /**登录id*/
    private Integer loginid;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", iconheader='" + iconheader + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", salary=" + salary +
                ", education1='" + education1 + '\'' +
                ", education2='" + education2 + '\'' +
                ", education3='" + education3 + '\'' +
                ", education4='" + education4 + '\'' +
                ", ishigheducation=" + ishigheducation +
                ", deptpositionid=" + deptpositionid +
                ", deptposition='" + deptposition + '\'' +
                ", addressid=" + addressid +
                ", address='" + address + '\'' +
                ", createtime=" + createtime +
                ", loginid=" + loginid +
                '}';
    }

    public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    public String getEducation1() {
        return education1;
    }

    public void setEducation1(String education1) {
        this.education1 = education1;
    }

    public String getEducation2() {
        return education2;
    }

    public void setEducation2(String education2) {
        this.education2 = education2;
    }

    public String getEducation3() {
        return education3;
    }

    public void setEducation3(String education3) {
        this.education3 = education3;
    }

    public String getEducation4() {
        return education4;
    }

    public void setEducation4(String education4) {
        this.education4 = education4;
    }

    public Integer getIshigheducation() {
        return ishigheducation;
    }

    public void setIshigheducation(Integer ishigheducation) {
        this.ishigheducation = ishigheducation;
    }

    public Integer getDeptpositionid() {
        return deptpositionid;
    }

    public void setDeptpositionid(Integer deptpositionid) {
        this.deptpositionid = deptpositionid;
    }

    public String getDeptposition() {
        return deptposition;
    }

    public void setDeptposition(String deptposition) {
        this.deptposition = deptposition;
    }

    public String getIconheader() {
        return iconheader;
    }

    public void setIconheader(String iconheader) {
        this.iconheader = iconheader;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCreatetime() {
        return SpringUtils.Date2String(createtime);
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

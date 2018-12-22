package com.boot.entity;

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
    /**地址id*/
    @JsonIgnore
    private Integer addressid;
    /**地址（伪列）*/
    private String address;
    /**创建时间*/
    private Date createtime;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

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
                ", addressid=" + addressid +
                ", address='" + address + '\'' +
                ", createtime=" + createtime +
                '}';
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

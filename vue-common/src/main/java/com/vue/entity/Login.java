package com.vue.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Login {
    /**主键*/
    private Integer id;
    /**账号*/
    private String username;
    /**密码*/
    private String password;
    /**随机码*/
    private String code;
}

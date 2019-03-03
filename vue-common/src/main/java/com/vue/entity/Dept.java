package com.vue.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 部门
 */
@Getter
@Setter
@ToString
public class Dept {
    /**主键*/
    private Integer id;
    /**部门*/
    private String department;
}

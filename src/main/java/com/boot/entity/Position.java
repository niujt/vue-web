package com.boot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 职位
 */
@Getter
@Setter
@ToString
public class Position {
    /**主键*/
    private Integer id;
    /**职位名称*/
    private String positionName;
    /**部门id*/
    private Integer deptid;

}

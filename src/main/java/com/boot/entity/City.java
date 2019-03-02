package com.boot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class City{
    /**主键*/
    private Integer id;
    /**城市*/
    private String cityname;
    /**省id*/
    private Integer provinceid;
    /**省*/
    private String provincename;
}

package com.boot.entity;

public class City{
    /**主键*/
    private Integer id;
    /**城市*/
    private String cityname;
    /**省id*/
    private Integer provinceid;
    /**省*/
    private String provincename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityname='" + cityname + '\'' +
                ", provinceid=" + provinceid +
                ", provincename='" + provincename + '\'' +
                '}';
    }
}

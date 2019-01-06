package com.boot.entity;

/**
 * 省份
 */

public class Province {
    /**主键*/
    private Integer id;
    /**省*/
    private String provincename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", provincename='" + provincename + '\'' +
                '}';
    }
}

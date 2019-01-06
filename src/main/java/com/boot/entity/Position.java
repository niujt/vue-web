package com.boot.entity;

/**
 * 职位
 */
public class Position {
    /**主键*/
    private Integer id;
    /**职位名称*/
    private String positionName;

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionName='" + positionName + '\'' +
                ", deptid=" + deptid +
                '}';
    }

    /**部门id*/
    private Integer deptid;

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

}

package com.boot.entity;

/**
 * 部门
 */
public class Dept {
    /**主键*/
    private Integer id;
    /**部门*/
    private String department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", department='" + department + '\'' +
                '}';
    }
}

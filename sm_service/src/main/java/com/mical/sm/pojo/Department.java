package com.mical.sm.pojo;

/**
 * 类 名 称：Department
 * 类 描 述：部门信息实体类
 * 创建时间：2019/5/23 10:30
 * 创建人：Mical
 */
public class Department {
    private Integer id;
    private String name;
    private String address;

    public Department() {
    }

    public Department(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

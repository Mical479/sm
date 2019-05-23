package com.mical.sm.service;

import com.mical.sm.pojo.Department;

import java.util.List;

/**
 * 类 名 称：DepartmentService
 * 类 描 述：部门信息的业务层接口
 * 创建时间：2019/5/23 10:49
 * 创建人：Mical
 */
public interface DepartmentService {
    /**
     * 添加部门
     * @param department 部门对象
     */
    void add(Department department);

    /**
     * 删除一个部门
     * @param id 部门id
     */
    void remove(Integer id);

    /**
     * 编辑部门信息，根据id编辑其他属性
     * @param department 部门对象
     */
    void edit(Department department);

    /**
     * 获取部门
     * @param id 部门id
     * @return 部门对象
     */
    Department get(Integer id);

    /**
     * 获取所有部门
     * @return 部门列表
     */
    List<Department> getAll();
}

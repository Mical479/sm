package com.mical.sm.dao;

import com.mical.sm.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名 称：DepartmentDao
 * 类 描 述：部门信息管理接口
 * 创建时间：2019/5/23 10:32
 * 创建人：Mical
 */
@Repository("departmentDao")
public interface DepartmentDao {
    /**
     * 插入部门信息
     * @param department 部门对象
     */
    void insert(Department department);

    /**
     * 删除某个部门
     * @param id 部门id
     */
    void delete(Integer id);

    /**
     * 更新某个部门属性
     * @param department 部门对象
     */
    void update(Department department);

    /**
     * 根据部门id查询部门信息
     * @param id 部门id
     * @return 部门对象
     */
    Department selectById(Integer id);

    /**
     * 查询所有部门
     * @return 部门列表
     */
    List<Department> selectAll();
}

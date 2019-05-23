package com.mical.sm.service;

import com.mical.sm.pojo.Staff;

import java.util.List;

/**
 * 类 名 称：StaffService
 * 类 描 述：员工管理的业务层接口
 * 创建时间：2019/5/23 13:42
 * 创建人：Mical
 */
public interface StaffService {
    /**
     * 添加员工
     * @param staff 员工对象
     */
    void add(Staff staff);

    /**
     * 删除员工
     * @param id 员工id
     */
    void remove(Integer id);

    /**
     * 编辑员工的所属部门
     * @param staff 部门对象
     */
    void edit(Staff staff);

    /**
     * 获取员工信息
     * @param id 员工id
     * @return 员工对象
     */
    Staff get(Integer id);

    /**
     * 获取所有员工
     * @return 员工列表
     */
    List<Staff> getAll();
}

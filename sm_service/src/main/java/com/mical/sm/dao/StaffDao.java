package com.mical.sm.dao;

import com.mical.sm.pojo.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名 称：StaffDao
 * 类 描 述：员工实体类
 * 创建时间：2019/5/23 13:24
 * 创建人：Mical
 */
@Repository("staffDao")
public interface StaffDao {

    /**
     * 插入员工
     * @param staff 员工对象
     */
    void insert(Staff staff);

    /**
     * 删除员工
     * @param id 员工id
     */
    void delete(Integer id);

    /**
     * 更改员工信息
     * @param staff 员工对象
     */
    void update(Staff staff);

    /**
     * 根据id查询员工
     * @param id 员工id
     * @return 员工对象
     */
    Staff selectById(Integer id);

    /**
     * 查询所有员工
     * @return 员工列表
     */
    List<Staff> selectAll();
}

package com.mical.sm.service.impl;

import com.mical.sm.dao.DepartmentDao;
import com.mical.sm.pojo.Department;
import com.mical.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类 名 称：DepartmentServiceImpl
 * 类 描 述：部门管理的业务层实现
 * 创建时间：2019/5/23 10:52
 * 创建人：Mical
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department get(Integer id) {
        return departmentDao.selectById(id);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}

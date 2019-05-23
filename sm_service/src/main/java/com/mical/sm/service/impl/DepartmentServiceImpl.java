package com.mical.sm.service.impl;

import com.mical.sm.dao.DepartmentDao;
import com.mical.sm.pojo.Department;
import com.mical.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * �� �� �ƣ�DepartmentServiceImpl
 * �� �� �������Ź����ҵ���ʵ��
 * ����ʱ�䣺2019/5/23 10:52
 * �����ˣ�Mical
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

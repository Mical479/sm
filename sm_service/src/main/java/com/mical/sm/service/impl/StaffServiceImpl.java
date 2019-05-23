package com.mical.sm.service.impl;

import com.mical.sm.dao.StaffDao;
import com.mical.sm.pojo.Staff;
import com.mical.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 类 名 称：StaffServiceImpl
 * 类 描 述：员工管理业务层实现
 * 创建时间：2019/5/23 13:45
 * 创建人：Mical
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public void add(Staff staff) {
        staff.setPassword("123456");
        staff.setWorkTime(new Date());
        staff.setStatus("正常");
        staffDao.insert(staff);
    }

    @Override
    public void remove(Integer id) {
        staffDao.delete(id);
    }

    @Override
    public void edit(Staff staff) {
        staffDao.update(staff);
    }

    @Override
    public Staff get(Integer id) {
        return staffDao.selectById(id);
    }

    @Override
    public List<Staff> getAll() {
        return staffDao.selectAll();
    }
}

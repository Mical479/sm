package com.mical.sm.service.impl;

import com.mical.sm.dao.SelfDao;
import com.mical.sm.dao.StaffDao;
import com.mical.sm.pojo.Staff;
import com.mical.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类 名 称：SelfServiceImpl
 * 类 描 述：登录功能业务层
 * 创建时间：2019/5/23 15:50
 * 创建人：Mical
 */
@Service("selfService")
public class SelfServiceImpl implements SelfService {

    @Autowired
    private SelfDao selfDao;

    @Autowired
    private StaffDao staffDao;

    @Override
    public Staff login(String account, String password) {
        Staff staff = selfDao.selectByAccount(account);
        if (staff == null){
            return null;
        }
        if (staff.getPassword().equals(password)){
            return staff;
        }
        return null;
    }

    @Override
    public void changePassword(Integer id, String password) {
        Staff staff = staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}

package com.mical.sm.service;

import com.mical.sm.pojo.Staff;

/**
 * 类 名 称：SelfService
 * 类 描 述：登录业务处理
 * 创建时间：2019/5/23 15:49
 * 创建人：Mical
 */
public interface SelfService {
    /**
     * 登录功能实现
     * @param account 账户名
     * @param password 密码
     * @return 员工对象
     */
    Staff login(String account, String password);

    /**
     * 修改密码
     * @param id 员工id
     * @param password 员工密码
     */
    void changePassword(Integer id, String password);
}

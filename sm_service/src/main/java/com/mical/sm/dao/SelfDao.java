package com.mical.sm.dao;

import com.mical.sm.pojo.Staff;
import org.springframework.stereotype.Repository;

/**
 * 类 名 称：SelfDao
 * 类 描 述：登录
 * 创建时间：2019/5/23 15:43
 * 创建人：Mical
 */
@Repository("selfDao")
public interface SelfDao {
    /**
     * 根据账号获取员工
     * @param account 员工账号
     * @return 员工对象
     */
    Staff selectByAccount(String account);
}

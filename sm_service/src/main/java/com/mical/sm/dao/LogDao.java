package com.mical.sm.dao;

import com.mical.sm.pojo.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名 称：LogDao
 * 类 描 述：日志接口
 * 创建时间：2019/5/23 16:55
 * 创建人：Mical
 */
@Repository("logDao")
public interface LogDao {
    void insert(Log log);
    List<Log> selectByType(String type);
}

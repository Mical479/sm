package com.mical.sm.service;

import com.mical.sm.pojo.Log;

import java.util.List;

/**
 * 类 名 称：LogService
 * 类 描 述：日志业务层
 * 创建时间：2019/5/23 17:01
 * 创建人：Mical
 */
public interface LogService {
    /**
     * 添加系统日志
     * @param log 日志对象
     */
    void addSystemLog(Log log);

    /**
     * 添加登录日志
      * @param log 日志对象
     */
    void addLoginLog(Log log);

    /**
     * 添加操作日志
     * @param log 日志对象
     */
    void addOperationLog(Log log);

    /**
     * 查看系统日志
     * @return 日志列表
     */
    List<Log> getSystemLog();

    /**
     * 查看登录日志
     * @return 日志列表
     */
    List<Log> getLoginLog();

    /**
     * 查看操作日志
     * @return 日志列表
     */
    List<Log> getOperationLog();
}

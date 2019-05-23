package com.mical.sm.service.impl;

import com.mical.sm.dao.LogDao;
import com.mical.sm.pojo.Log;
import com.mical.sm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 类 名 称：LogServiceImpl
 * 类 描 述：日志业务层处理
 * 创建时间：2019/5/23 17:05
 * 创建人：Mical
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void addSystemLog(Log log) {
        log.setOprTime(new Date());
        log.setType("system");
        logDao.insert(log);
    }

    @Override
    public void addLoginLog(Log log) {
        log.setOprTime(new Date());
        log.setType("login");
        logDao.insert(log);
    }

    @Override
    public void addOperationLog(Log log) {
        log.setOprTime(new Date());
        log.setType("operation");
        logDao.insert(log);
    }

    @Override
    public List<Log> getSystemLog() {
        return logDao.selectByType("system");
    }

    @Override
    public List<Log> getLoginLog() {
        return logDao.selectByType("login");
    }

    @Override
    public List<Log> getOperationLog() {
        return logDao.selectByType("operation");
    }
}

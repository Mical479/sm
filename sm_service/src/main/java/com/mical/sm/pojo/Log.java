package com.mical.sm.pojo;

import java.util.Date;

/**
 * 类 名 称：Log
 * 类 描 述：日志对象实体类
 * 创建时间：2019/5/23 16:53
 * 创建人：Mical
 */
public class Log {
    private Date oprTime;
    private String type;
    private String operator;
    private String moudle;
    private String operation;
    private String result;

    public Date getOprTime() {
        return oprTime;
    }

    public void setOprTime(Date oprTime) {
        this.oprTime = oprTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getMoudle() {
        return moudle;
    }

    public void setMoudle(String moudle) {
        this.moudle = moudle;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
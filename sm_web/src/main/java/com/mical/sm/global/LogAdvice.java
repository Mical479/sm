package com.mical.sm.global;

import com.mical.sm.pojo.Log;
import com.mical.sm.pojo.Staff;
import com.mical.sm.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 类 名 称：LogAdvice
 * 类 描 述：日志切面
 * 创建时间：2019/5/23 17:15
 * 创建人：Mical
 */
@Component
@Aspect
@SuppressWarnings("all")
public class LogAdvice {

    @Autowired
    private LogService logService;

    @After("execution(* com.mical.sm.controller.*.*(..)) && !execution(* com.mical.sm.controller.SelfController.*(..)) && !execution(* com.mical.sm.controller.*.to*(..))")
    public void operationLog(JoinPoint joinPoint){
        Log log = new Log();
        //获取类名
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        //获取方法名
        log.setOperation(joinPoint.getSignature().getName());
        //获取传入方法的 request 对象
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff = (Staff) obj;
        log.setOperator(staff.getAccount());
        log.setResult("成功");
        logService.addOperationLog(log);
    }

    @AfterThrowing(throwing = "e", pointcut = "execution(* com.mical.sm.controller.*.*(..)) && !execution(* com.mical.sm.controller.SelfController.*(..))")
    public void systemLog(JoinPoint joinPoint, Throwable e){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff = (Staff) obj;
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);
    }

    @After("execution(* com.mical.sm.controller.SelfController.login(..))")
    public void loginLog(JoinPoint joinPoint){
        log(joinPoint);
    }

    @Before("execution(* com.mical.sm.controller.SelfController.logout(..))")
    public void logoutLog(JoinPoint joinPoint){
        log(joinPoint);
    }

    private void log(JoinPoint joinPoint){
        Log log = new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        if (obj==null){
            log.setOperator(request.getParameter("account"));
            log.setResult("失败");
        }else {
            Staff staff = (Staff) obj;
            log.setOperator(staff.getAccount());
            log.setResult("成功");
        }
        logService.addLoginLog(log);
    }
}

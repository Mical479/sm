package com.mical.sm.controller;

import com.mical.sm.pojo.Log;
import com.mical.sm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 类 名 称：LogController
 * 类 描 述：日志记录
 * 创建时间：2019/5/23 17:29
 * 创建人：Mical
 */
@Controller("logController")
public class LogController {

    @Autowired
    private LogService logService;

    public void operationLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list = logService.getOperationLog();
        request.setAttribute("LIST", list);
        request.setAttribute("TYPE", "操作");
        request.getRequestDispatcher("../log_list.jsp").forward(request, response);
    }

    public void loginLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list = logService.getLoginLog();
        request.setAttribute("LIST", list);
        request.setAttribute("TYPE", "登录");
        request.getRequestDispatcher("../log_list.jsp").forward(request, response);
    }

    public void systemLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> list = logService.getSystemLog();
        request.setAttribute("LIST", list);
        request.setAttribute("TYPE", "系统");
        request.getRequestDispatcher("../log_list.jsp").forward(request, response);
    }
}

package com.mical.sm.controller;

import com.mical.sm.pojo.Department;
import com.mical.sm.pojo.Staff;
import com.mical.sm.service.DepartmentService;
import com.mical.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 类 名 称：StaffController
 * 类 描 述：关于员工的Controller实现
 * 创建时间：2019/5/23 10:55
 * 创建人：Mical
 */
@Controller("staffController")
@SuppressWarnings("all")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> list = staffService.getAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("../staff_list.jsp").forward(request, response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("DLIST", list);
        request.getRequestDispatcher("../staff_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String info = request.getParameter("info");
        Date bornDate = null;
        try{
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer did = Integer.parseInt(request.getParameter("did"));

        Staff staff = new Staff();
        staff.setInfo(info);
        staff.setBornDate(bornDate);
        staff.setIdNumber(idNumber);
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);

        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("OBJ", staff);

        List<Department> list = departmentService.getAll();
        request.setAttribute("DLIST", list);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String info = request.getParameter("info");
        Date bornDate = null;
        try{
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer did = Integer.parseInt(request.getParameter("did"));

        Staff staff = staffService.get(id);
        staff.setInfo(info);
        staff.setBornDate(bornDate);
        staff.setIdNumber(idNumber);
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);

        staffService.edit(staff);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        response.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("OBJ", staff);

        request.getRequestDispatcher("../staff_detail.jsp").forward(request, response);
    }

}

package com.mical.sm.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 类 名 称：DispatcherServlet
 * 类 描 述：核心控制器，将Web容器中的Servlet交给Sprig IOC容器管理
 * 创建时间：2019/5/23 9:54
 * 创建人：Mical
 */
public class DispatcherServlet extends GenericServlet {

    //spring上下文加载对象
    private ApplicationContext context;

    /**
     * 初始化时加载spring配置文件
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        context = new ClassPathXmlApplicationContext("spring.xml");
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //分割访问路径：staff/add.do  -> 类名Controller/方法名.do
        String path = request.getServletPath().substring(1);
        String beanName = null;
        String methodName = null;
        int index = path.indexOf('/');

        //通过分割访问路径，得到访问的 bean 名称 和方法名称
        if (index != -1) {
            beanName = path.substring(0, index) + "Controller";
            methodName = path.substring(index + 1, path.indexOf(".do"));
        } else {
            beanName = "selfController";
            methodName = path.substring(0, path.indexOf(".do"));
        }

        //通过context获取bean后，通过反射调用Bean的方法
        Object obj = context.getBean(beanName);
        try {
            Method method = obj.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(obj, request, response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

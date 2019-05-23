package com.mical.sm.global;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * 类 名 称：EncodingFilter
 * 类 描 述：过滤器，设置request和response的编码格式
 * 创建时间：2019/5/22 20:43
 * 创建人：Mical
 */
@WebFilter("/*")
@WebInitParam(name = "encoding",value = "UTF-8")
public class EncodingFilter implements Filter {

    private String encoding = "UTF-8";

    public void init(FilterConfig filterConfig) throws ServletException {
        if (filterConfig.getInitParameter("ENCODING") != null) {
            encoding = filterConfig.getInitParameter("ENCODING");
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        encoding = null;
    }
}

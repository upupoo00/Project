package com.shopping.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/main/*")
public class GrantFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("权限过滤器执行");
        HttpServletRequest request1=(HttpServletRequest)request;
        HttpServletResponse response1= (HttpServletResponse)response;
        Object obj=request1.getSession().getAttribute("user");
        if(obj==null){
            response1.sendRedirect("../Login.jsp");
            return;
        }
        //用户不为空时，放行
        chain.doFilter(request,response);//
    }

    @Override
    public void destroy() {

    }
}


package com.shopping.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
     //字符集过滤
        request.setCharacterEncoding("utf-8");
     response.setCharacterEncoding("utf-8");
     chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}

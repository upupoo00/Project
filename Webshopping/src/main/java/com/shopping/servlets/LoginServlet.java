package com.shopping.servlets;

import com.shopping.dao.UserDao;
import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.model.User;
import com.shopping.service.UserService;
import com.shopping.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user.do")
public class LoginServlet extends BaseServlet {
private UserService us=new UserServiceImpl();

    //登录
    protected void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String username=request.getParameter("username");
     String password=request.getParameter("password");
     //System.out.println(username+password);
     //先判断是否为空
     if(!username.equals("")){
         User user=us.login(username,password);
         if(user!=null){
           //判断类型
             if(user.getType()==1) {
                 HttpSession session = request.getSession();
                 session.setAttribute("user", user);
                 response.sendRedirect("index.jsp");
             }else if(user.getType()==0){
                 HttpSession session = request.getSession();
                 session.setAttribute("user", user);
                 response.sendRedirect("manager.jsp");
             }
         }else{
             request.setAttribute("msg", "账号密码不正确");
             request.getRequestDispatcher("Login.jsp").forward(request,response);
         }
     }else{
         request.setAttribute("msg","账号密码不能为空");
         request.getRequestDispatcher("Login.jsp").forward(request,response);
     }
    }
}

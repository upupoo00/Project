package com.shopping.servlets;

import com.shopping.model.User;
import com.shopping.service.UserService;
import com.shopping.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/updateDoUser.do","/Reg.do","/updateToUsermanager.do","/updateDoUsermanager.do","/deleteUsermanager.do"})
public class UserServlet extends BaseServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService us=new UserServiceImpl();
        String path=request.getServletPath();   //得到urlPatternWWs路径
        if("/updateDoUser.do".equals(path)){
             String username=request.getParameter("username");
             User user=us.getUserByName(username);
             int uid=user.getUid();
             if(user!=null){
                String realname=request.getParameter("realname");
                String sex=request.getParameter("sex");
                String sno=request.getParameter("sno");
                String dormitory=request.getParameter("dormitory");
                String phone=request.getParameter("phone");
                String password=request.getParameter("password");
                String type=request.getParameter("type");
                User user1=new User();
                 user1.setUid(uid);
                 user1.setUsername(username);
                 user1.setPhone(phone);
                 user1.setRealname(realname);
                 user1.setSno(Integer.parseInt(sno));
                 user1.setDormitory(dormitory);
                 user1.setSex(sex);
                 user1.setPassword(password);
                 user1.setType(Integer.parseInt(type));
                 us.updateUser(user1);
                 //判断密码是否被修改
                 if(password.equals(user.getPassword())){
//                     request.setAttribute("user", user1);
//                     request.getRequestDispatcher("userinformation.jsp").forward(request,response);
                     response.sendRedirect("userinformation.jsp");
                 }else{
                     response.sendRedirect("Login.jsp");
                 }
             }
        }
        if("/Reg.do".equals(path)){
            String username=request.getParameter("username");
            String realname=request.getParameter("realname");
            String sex=request.getParameter("sex");
            String sno=request.getParameter("sno");
            String dormitory=request.getParameter("dormitory");
            String phone=request.getParameter("phone");
            String password=request.getParameter("password");
            User user=new User();
            user.setUsername(username);
            user.setPhone(phone);
            user.setRealname(realname);
            user.setSno(Integer.parseInt(sno));
            user.setDormitory(dormitory);
            user.setSex(sex);
            user.setPassword(password);
            us.addUser(user);
            response.sendRedirect("Login.jsp");
        }
        if("/updateToUsermanager.do".equals(path)){
            String uid=request.getParameter("uid");
            User user=us.getUser(Integer.parseInt(uid));
            request.setAttribute("user",user);
            request.getRequestDispatcher("updateUser.jsp").forward(request,response);
        }
        if("/updateDoUsermanager.do".equals(path)) {
            String uid = request.getParameter("uid");
            String username = request.getParameter("username");
            String realname = request.getParameter("realname");
            String sex = request.getParameter("sex");
            String sno = request.getParameter("sno");
            String dormitory = request.getParameter("dormitory");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            String type = request.getParameter("type");
            User user1 = new User();
            user1.setUid(Integer.parseInt(uid));
            user1.setUsername(username);
            user1.setPhone(phone);
            user1.setRealname(realname);
            user1.setSno(Integer.parseInt(sno));
            user1.setDormitory(dormitory);
            user1.setSex(sex);
            user1.setPassword(password);
            user1.setType(Integer.parseInt(type));
            us.updateUser(user1);
            //判断密码是否被修改
            response.sendRedirect("manager.jsp");

            }
        if("/deleteUsermanager.do".equals(path)){
            String uid=request.getParameter("uid");
            us.deleteUser(Integer.parseInt(uid));
            response.sendRedirect("manager.jsp");
        }
    }
}

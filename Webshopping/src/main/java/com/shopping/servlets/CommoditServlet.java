package com.shopping.servlets;

import com.shopping.model.Commodit;
import com.shopping.service.CommoditService;
import com.shopping.service.impl.CommoditServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/updateToCommodit.do","/updateDoCommodit.do","/deleteDoCommodit.do",
        "/commodit.do","/addCommodit.do","/findCommoditBySort.do","/findCommoditByName.do",
        "/updateToCommoditmanager.do","/updateDoCommoditmanager.do","/deleteCommoditmanager.do"})
public class CommoditServlet extends BaseServlet {
  private CommoditService cs=new CommoditServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();   //得到urlPatternWWs路径
           if("/updateToCommodit.do".equals(path)){
               String sid=request.getParameter("sid");
               Commodit commodit=cs.getCommodit(Integer.parseInt(sid));
//               System.out.println(commodit);
               request.setAttribute("commodit",commodit);
               request.getRequestDispatcher("updatecommodit.jsp").forward(request,response);
           }
        if("/updateDoCommodit.do".equals(path)){
            String sid=request.getParameter("sid");
            String name=request.getParameter("name");
            String level=request.getParameter("level");
            String remark=request.getParameter("remark");
            String price=request.getParameter("price");
            String sort=request.getParameter("sort");
            String count=request.getParameter("count");
            String uid=request.getParameter("uid");
            String image=request.getParameter("image");
            Commodit commodit=new Commodit();
            commodit.setName(name);
            commodit.setLevel(level);
            commodit.setRemark(remark);
            commodit.setPrice(Double.parseDouble(price));
            commodit.setSort(sort);
            commodit.setCount(Integer.parseInt(count));
            commodit.setUid(Integer.parseInt(uid));
            commodit.setImage(image);
            commodit.setSid(Integer.parseInt(sid));
            cs.updateCommodit(commodit);
//            response.sendRedirect("userinformation.jsp");
            request.setAttribute("commodit",commodit);
            request.getRequestDispatcher("updatecommodit.jsp").forward(request,response);
        }
        if("/deleteDoCommodit.do".equals(path)){
            String sid=request.getParameter("sid");
            cs.deleteCommodit(Integer.parseInt(sid));
            response.sendRedirect("userinformation.jsp");
        }
        if("/commodit.do".equals(path)){
            String sid=request.getParameter("sid");
            Commodit commodit=cs.getCommodit(Integer.parseInt(sid));
            request.setAttribute("commodit",commodit);
            request.getRequestDispatcher("commodit.jsp").forward(request,response);
        }
        if("/addCommodit.do".equals(path)){
            String sort=request.getParameter("sort");
            String level=request.getParameter("level");
            String  name=request.getParameter("name");
            String remark=request.getParameter("remark");
            String price=request.getParameter("price");
            String count=request.getParameter("count");
            String uid=request.getParameter("uid");
            String image=request.getParameter("image");
            Commodit commodit=new Commodit();
            commodit.setSort(sort);
            commodit.setLevel(level);
            commodit.setName(name);
            commodit.setRemark(remark);
            commodit.setPrice(Double.parseDouble(price));
            commodit.setCount(Integer.parseInt(count));
            commodit.setUid(Integer.parseInt(uid));
            commodit.setImage(image);
            cs.addCommodit(commodit);
            response.sendRedirect("useraddcommodit.jsp");
        }
        if("/findCommoditBySort.do".equals(path)){
            String sort=request.getParameter("sort");
            List<Commodit> list=cs.getCommoditBySort(sort);
            request.setAttribute("list",list);
            request.getRequestDispatcher("findCommoditBySort.jsp").forward(request,response);
        }
        if("/findCommoditByName.do".equals(path)){
            String findname=request.getParameter("findname");
            List<Commodit> list=cs.getCommoditByName(findname);
            request.setAttribute("list",list);
            request.getRequestDispatcher("findCommoditByName.jsp").forward(request,response);
        }
        if("/updateToCommoditmanager.do".equals(path)){
            String sid=request.getParameter("sid");
            Commodit commodit=cs.getCommodit(Integer.parseInt(sid));
//               System.out.println(commodit);
            request.setAttribute("commodit",commodit);
            request.getRequestDispatcher("updateCommoditmanager.jsp").forward(request,response);
        }
        if("/updateDoCommoditmanager.do".equals(path)){
            String sid=request.getParameter("sid");
            String name=request.getParameter("name");
            String level=request.getParameter("level");
            String remark=request.getParameter("remark");
            String price=request.getParameter("price");
            String sort=request.getParameter("sort");
            String count=request.getParameter("count");
            String uid=request.getParameter("uid");
            String image=request.getParameter("image");
            Commodit commodit=new Commodit();
            commodit.setName(name);
            commodit.setLevel(level);
            commodit.setRemark(remark);
            commodit.setPrice(Double.parseDouble(price));
            commodit.setSort(sort);
            commodit.setCount(Integer.parseInt(count));
            commodit.setUid(Integer.parseInt(uid));
            commodit.setImage(image);
            commodit.setSid(Integer.parseInt(sid));
            cs.updateCommodit(commodit);
            response.sendRedirect("managerCommodit.jsp");
        }
        if("/deleteCommoditmanager.do".equals(path)){
            String sid=request.getParameter("sid");
            cs.deleteCommodit(Integer.parseInt(sid));
            response.sendRedirect("managerCommodit.jsp");
        }
    }
}

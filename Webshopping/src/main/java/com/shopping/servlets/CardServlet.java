package com.shopping.servlets;

import com.shopping.model.Cart;
import com.shopping.model.Commodit;
import com.shopping.service.CartService;
import com.shopping.service.CommoditService;
import com.shopping.service.impl.CartServiceImpl;
import com.shopping.service.impl.CommoditServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.function.DoubleToIntFunction;

@WebServlet(urlPatterns = {"/addCart.do","/addCartShopping.do","/addCartIndex.do","/deleteCart.do","/addCartSort.do","/getOrder.do"})
public class CardServlet extends BaseServlet {
    private CartService cs=new CartServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        if("/addCart.do".equals(path)){
            String id=request.getParameter("id");
            //字符串分割
            String[] strArray = id.split(",");
            int sid=Integer.parseInt(strArray[0]);
            int uid=Integer.parseInt(strArray[1]);
            //判断uid是否为0
            if(uid!=0) {
//            System.out.println(sid);
//            System.out.println(uid);
                int commoditcount = cs.getcartcount(uid, sid);
//            System.out.println(commoditcount);
                //判断数量是否为零
                if (commoditcount == 0) {
                    Cart cart = new Cart();
                    cart.setSid(sid);
                    cart.setUid(uid);
                    cart.setCount(1);
                    cs.addcart(cart);
                } else {
                    Cart cart = new Cart();
                    cart.setSid(sid);
                    cart.setUid(uid);
                    cart.setCount(commoditcount + 1);
                    cs.updatecart(cart);
                }
                CommoditService cds=new CommoditServiceImpl();
                Commodit commodit=cds.getCommodit(sid);
              request.setAttribute("commodit",commodit);
              request.getRequestDispatcher("commodit.jsp").forward(request,response);
            }else {
                response.sendRedirect("Login.jsp");
            }
        }
        if("/addCartShopping.do".equals(path)){
            String id=request.getParameter("id");
            //字符串分割
            String[] strArray = id.split(",");
            int sid=Integer.parseInt(strArray[0]);
            int uid=Integer.parseInt(strArray[1]);
            //判断uid是否为0
            if(uid!=0) {
//            System.out.println(sid);
//            System.out.println(uid);
                int commoditcount = cs.getcartcount(uid, sid);
//            System.out.println(commoditcount);
                //判断数量是否为零
                if (commoditcount == 0) {
                    Cart cart = new Cart();
                    cart.setSid(sid);
                    cart.setUid(uid);
                    cart.setCount(1);
                    cs.addcart(cart);
                } else {
                    Cart cart = new Cart();
                    cart.setSid(sid);
                    cart.setUid(uid);
                    cart.setCount(commoditcount + 1);
                    cs.updatecart(cart);
                }
//            request.setAttribute("commodit",commodit);
//            request.getRequestDispatcher("commodit.jsp").forward(request,response);
                response.sendRedirect("shopping.jsp");
            }else {
                response.sendRedirect("Login.jsp");
            }
        }
        if("/addCartIndex.do".equals(path)){
            String id=request.getParameter("id");
            //字符串分割
            String[] strArray = id.split(",");
            int sid=Integer.parseInt(strArray[0]);
            int uid=Integer.parseInt(strArray[1]);
            //判断uid是否为0
            if(uid!=0) {
//            System.out.println(sid);
//            System.out.println(uid);
                int commoditcount = cs.getcartcount(uid, sid);
//            System.out.println(commoditcount);
                //判断数量是否为零
                if (commoditcount == 0) {
                    Cart cart = new Cart();
                    cart.setSid(sid);
                    cart.setUid(uid);
                    cart.setCount(1);
                    System.out.println(cs.addcart(cart));
                } else {
                    Cart cart = new Cart();
                    cart.setSid(sid);
                    cart.setUid(uid);
                    cart.setCount(commoditcount + 1);
                    System.out.println(cs.updatecart(cart));
                }
//            request.setAttribute("commodit",commodit);
//            request.getRequestDispatcher("commodit.jsp").forward(request,response);
                response.sendRedirect("index.jsp");
            }else {
                response.sendRedirect("Login.jsp");
            }
        }
        if("/deleteCart.do".equals(path)){
              String cid=request.getParameter("cid");
              cs.deletecart(Integer.parseInt(cid));
              response.sendRedirect("cart.jsp");
        }
        if("/addCartSort.do".equals(path)){
            String id=request.getParameter("id");
            //字符串分割
            String[] strArray = id.split(",");
            int sid=Integer.parseInt(strArray[0]);
            int uid=Integer.parseInt(strArray[1]);
            String sort=strArray[2];
            //判断uid是否为0
            if(uid!=0) {
//            System.out.println(sid);
//            System.out.println(uid);
                int commoditcount = cs.getcartcount(uid, sid);
//            System.out.println(commoditcount);
                //判断数量是否为零
                if (commoditcount == 0) {
                    Cart cart = new Cart();
                    cart.setSid(sid);
                    cart.setUid(uid);
                    cart.setCount(1);
                    cs.addcart(cart);
                } else {
                    Cart cart = new Cart();
                    cart.setSid(sid);
                    cart.setUid(uid);
                    cart.setCount(commoditcount + 1);
                    cs.updatecart(cart);
                }
                CommoditService cds=new CommoditServiceImpl();
                List<Commodit> list=cds.getCommoditBySort(sort);
                request.setAttribute("list",list);
                request.getRequestDispatcher("findCommoditBySort.jsp").forward(request,response);
//                response.sendRedirect("findCommoditBySort.jsp");
            }else {
                response.sendRedirect("Login.jsp");
            }
        }
        if("/getOrder.do".equals(path)){
            String price[]=request.getParameterValues("check");
            double allprice = 0;
            if(price.length!=0) {
                for (int i = 0; i < price.length; i++) {
                    allprice = allprice + (Double.parseDouble(price[i]));
                }
            }
                request.setAttribute("allprice", allprice);
                request.getRequestDispatcher("order.jsp").forward(request, response);
        }
    }
}

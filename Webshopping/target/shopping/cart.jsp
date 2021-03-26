<%@ page import="java.util.*" %>
<%@ page import="com.shopping.service.CartService" %>
<%@ page import="com.shopping.service.impl.CartServiceImpl" %>
<%@ page import="com.shopping.service.CommoditService" %>
<%@ page import="com.shopping.service.impl.CommoditServiceImpl" %>
<%@ page import="com.shopping.model.Commodit" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shopping.model.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>校园二手市场主页</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/inhead.css" rel="stylesheet">
    <link href="css/card.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<%
   User user=(User)session.getAttribute("user");
   if (user==null){
%>
<script>
    alert("您还未登录哦~");
    window.location.href="Login.jsp";
</script>
<%
    }else {
%>
<%
   int uid=user.getUid();
    CartService cse=new CartServiceImpl();
    List sidlist=cse.getcartbyuid(user.getUid());
    //查找商品
    CommoditService cs=new CommoditServiceImpl();
    List<Commodit> commoditlist=new ArrayList<Commodit>();
    for(int i=0;i<sidlist.size();i++){
        int sid=(int)sidlist.get(i);
        Commodit commodit1=cs.getCommodit(sid);
        commoditlist.add(commodit1);
    }
    //总价格
    double allprice=0;
%>
<script>
    function dakai() {
        if (document.getElementById("checkAll").checked == false) {
            //3.获取下面所有的复选框
            var checkOnes = document.getElementsByName("check");
            //4.对获取的所有复选框进行遍历
            for (var i = 0; i < checkOnes.length; i++) {
                //5.拿到每一个复选框，并将其状态置为选中
                checkOnes[i].checked = true;
            }
        }

        function checkAll1() {
            //1.获取编号前面的复选框
            //2.对编号前面复选框的状态进行判断
            if (document.getElementById("checkAll").checked == true) {
                //3.获取下面所有的复选框
                var checkOnes = document.getElementsByName("check");
                //4.对获取的所有复选框进行遍历
                for (var i = 0; i < checkOnes.length; i++) {
                    //5.拿到每一个复选框，并将其状态置为选中
                    checkOnes[i].checked = true;
                }
            } else {
                //6.获取下面所有的复选框
                var checkOnes = document.getElementsByName("check");
                //7.对获取的所有复选框进行遍历
                for (var i = 0; i < checkOnes.length; i++) {
                    //8.拿到每一个复选框，并将其状态置为未选中
                    checkOnes[i].checked = false;
                }
            }
        }

        function deletecart() {
            alert("删除成功!");
        }
    }
</script>
<body>
    <!--导航-->
    <%@  include file="inbody.jsp"%>
   
     <!--购物车栏-->
     <div class="center-top"><p>购&nbsp;&nbsp;物&nbsp;&nbsp;车</p></div>
    
     <div class="center">
         <form action="getOrder.do" method="post">
             <table>
                 <thead >
                     <tr style="width: 100%;height: 50px;color: white;font-family: 微软雅黑; font-weight: bolder;">
                        <th style="width: 100px;border-radius:10px 0 0 10px;background-color: rgb(101, 104, 110);"></th> 
                        <th style="width: 400px;text-align: center;border-radius:0 10px 10px 0;background-color:  rgb(101, 104, 110);">商品信息</th>
                         <th style="width: 200px;text-align: center;border-radius: 10px;background-color: rgb(101, 104, 110);">商品金额</th>
                         <th style="width: 200px;text-align: center;border-radius: 10px;background-color:  rgb(101, 104, 110);">商品数量</th>
                         <th style="width: 200px;text-align: center;border-radius: 10px;background-color:  rgb(101, 104, 110);">总金额</th>
                         <th style="width: 200px;text-align: center;border-radius: 10px;background-color:  rgb(101, 104, 110);">编辑</th>
                     </tr>
                 </thead>
                 <tbody>
                     <!--此处放购物车信息-->
                     <%
                         for(int i=0;i<commoditlist.size();i++){
                             Commodit commodit=commoditlist.get(i);
                             pageContext.setAttribute("commodit",commodit);
                             int count=cse.getcartcount(uid,commodit.getSid());
                             int cid=cse.getcartbyid(uid,commodit.getSid());
                             allprice=allprice+(count)*commodit.getPrice();
                     %>
                     <tr style="border: 2px solid rgb(78, 77, 77);font-size: 15px;font-family: 微软雅黑; font-weight: bolder;text-align: center">
                         <td>
                            <input type="checkbox" name="check" style="position: relative;margin-left: 50px;" value="<%=commodit.getPrice()*count%>">
                         </td>
                         <td><img src="img/${commodit.image}" width="200px" height="150px">${commodit.name}</td>
                         <td>￥${commodit.price}元</td>
                         <td><%=count%></td>
                         <td>￥<%=commodit.getPrice()*count%>元</td>
                         <td>
                             <a href="deleteCart.do?cid=<%=cid%>"><input type="button" value="删除" onclick="deletecart()"></a></td>
                     </tr>
                      <%
                          }%>
                    <!--提交列-->
                <tr  style="border: 2px solid rgb(78, 77, 77);font-size: 15px;font-family: 微软雅黑; font-weight: bolder;height: 70px;">
                    <td>
                        <input type="checkbox" id="checkAll" onclick="checkAll1()" style="position: relative;margin-left: 40px;" />
                    <span id="spanss">全选</span></td>
                    <td colspan="5" ><div style="position: relative;margin-left: 800px;">总计：￥<%=allprice%>元&nbsp;&nbsp;&nbsp;
                        <input type="submit" value="提交" style="width: 100px;height: 30px;background-color: rgba(5, 94, 177, 0.986);border-radius: 10px;" onclick="dakai()">
                    </td>
                </tr>
                 </tbody>
             </table>
         </form>
    </div>
</body>
<%}%>
</html>

<%@ page import="com.shopping.model.Commodit" %>
<%@ page import="com.shopping.service.UserService" %>
<%@ page import="com.shopping.service.impl.UserServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>校园二手市场主页</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/commodit.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<%
 User user=(User)session.getAttribute("user");
    int uid=0;
    if(user!=null){
        uid=user.getUid();
    }
    Commodit commodit=(Commodit)request.getAttribute("commodit");
    //通过commodit.uid查找卖家信息
    UserService us=new UserServiceImpl();
    User user1=us.getUser(commodit.getUid());
%>
<script>
    function addCart() {
        <% if(uid!=0){%>
        alert("添加成功！");
        <%}else {%>
        alert("请先登录!");
        <%}%>
    }
</script>
<body>
    <!--导航-->
    <%@  include file="inbody.jsp"%>

    <!--中部-->
    <div class="center">
        <div class="center-top"><p>物品详细</p></div>
        <!--物品图片-->
         <div class="center-img">
              <img src="img/${commodit.image}" width="355px" height="350px">
         </div>

         <!--物品说明-->
         <div class="center-text">
             <br><br>
            <p style="font-size: 20px;">&nbsp;商品名:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);">${commodit.name}</span></p>
            <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;成色:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);">${commodit.level}</span></p>
            <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;数量:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);">${commodit.count}</span></p>
            <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;单价:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);">￥${commodit.price}</span></p>
            <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;分类:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);">${commodit.sort}</span></p>
            <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;详细:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);">卖家:<%=user1.getRealname()%>(联系:${user.phone})</span></p>
            <br>
             <a href="addCart.do?id=<%=commodit.getSid()+","+uid%>" style="font-size: 13px;color: rgb(136, 135, 135);">
                 <input type="button" value="加入购物车" class="center-input" onclick="addCart()" style="position: relative;left: 100px">
             </a>
         </div>
    </div>
</body>
</html>
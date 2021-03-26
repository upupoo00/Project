<%@ page import="com.shopping.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!--头部开始-->
<script>
    function findcommoditbyname() {
          var findname=document.getElementById("findname").value;
          window.location.href="findCommoditByName.do?findname="+findname;
    }
</script>
<div class="top">
    <c:if test="${user!=null}">
        <span style="color: black;font-size: 20px;font-weight: bold;">欢迎：${user.username}</span>
    </c:if>
    <c:if test="${user==null}">
        <span style="color: black;font-size: 20px;font-weight: bold;">您还未登录哦~</span>
    </c:if>
    <div class="top-1">
        <ul class="nav nav-pills">
            <li><a href="index.jsp">&nbsp;&nbsp;&nbsp;首页&nbsp;&nbsp;&nbsp;</a></li>
            <li><a href="shopping.jsp">&nbsp;&nbsp;&nbsp;商城&nbsp;&nbsp;&nbsp;</a></li>
            <li><a href="cart.jsp">&nbsp;&nbsp;&nbsp;购物车&nbsp;&nbsp;&nbsp;</a></li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    &nbsp;&nbsp;&nbsp;个人账户&nbsp;&nbsp;&nbsp;<span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="userinformation.jsp">个人信息</a></li>
                    <li><a href="order.jsp">个人订单</a></li>
                    <li><a href="useraddcommodit.jsp">发布商品</a></li>
                </ul>
            </li>
            <li><a href="#">&nbsp;&nbsp;&nbsp;联系我们&nbsp;&nbsp;&nbsp;</a></li>
            <c:if test="${user!=null}">
            <li><a href="exit.jsp">&nbsp;&nbsp;&nbsp;退出登录&nbsp;&nbsp;&nbsp;</a></li>
            </c:if>
            <c:if test="${user==null}">
            <li><a href="Login.jsp">&nbsp;&nbsp;&nbsp;登录&nbsp;&nbsp;&nbsp;</a></li>
            </c:if>
            <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </li>
    </div>
    <div class="top-2">
        <input type="text" placeholder="请输入要查询物品的信息" class="input-top" id="findname">
    </div>
    <div class="top-3">
        <a href="javascript:findcommoditbyname();" class="button-top"><span>搜索</span></a>
    </div>
</div>
    <!--头部结束-->

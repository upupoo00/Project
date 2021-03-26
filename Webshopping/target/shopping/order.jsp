<%

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
   <title>校园二手市场主页</title>
   <link href="css/bootstrap.min.css" rel="stylesheet">
   <link href="css/order.css" rel="stylesheet">
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
}else{
          double allprice=(Double)request.getAttribute("allprice");
%>
<body>
<%@  include file="inbody.jsp"%>

<div class="center">
   <div class="center-1">
      <span class="span1">收件信息</span>
      <div class="center-2">
         <span class="span2">收件人:${user.realname}</span>
         <span class="span3">电话:${user.phone}</span><br>
         <span class="span4">宿舍号:${user.dormitory}</span>
      </div>
      <div class="center-3">
         <div class="center3-1">
            <div class="center3-1-1"></div>
            <div class="center3-1-2"></div>
            <div class="center3-1-3"></div>
         </div>
         <div class="center3-1">
            <div class="center3-1-1"></div>
            <div class="center3-1-2"></div>
            <div class="center3-1-3"></div>
         </div>
         <div class="center3-1">
            <div class="center3-1-1"></div>
            <div class="center3-1-2"></div>
            <div class="center3-1-3"></div>
         </div>
      </div>
      <div class="center4">
         <span class="span5">付款方式</span>
      </div>
      <div class="center5">
         <img src="img/支付宝.png" style="width: 24px;height: 24px;position: relative;top: 10px;left: 20px;">
         <span class="span6">支付宝支付</span>
         <input type="checkbox" class="check1">
      </div>
      <div class="center6">
         <img src="img/微信.png" style="width: 24px;height: 24px;position: relative;top: 10px;left: 20px;">
         <span class="span6">微信支付</span>
         <input type="checkbox" class="check2">
      </div>
      <div class="center7">
         <span class="span1">备注:您有什么特殊的要告诉我吗？</span>
      </div>
      <div class="center8">
         <input type="text" style="width: 100%;height: 33px;">
      </div>
      <div class="center9">
         <span class="span7">合计金额:${allprice}元</span>
         <input type="button" value="提交" style="width: 100px;height: 30px;background-color: rgba(5, 94, 177, 0.986);border-radius: 10px;position: relative;left: 120px;"></div>
   </div>
</div>
</div>

</body>
</html>


<%}%>
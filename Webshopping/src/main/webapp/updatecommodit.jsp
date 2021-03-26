<%@ page import="com.shopping.model.Commodit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>校园二手市场主页</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/commodit.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<style>
    .button{
        display: inline-block;
        margin-top: 0;
        margin-left:145px;
        background: #000;
        border: none;
        color: #FFF;
        height: 35px;
        width: 100px;
        text-align: center;
        font-weight: bold;
        border-radius: 5px;
    }
</style>
<script>
    function update(){
        alert("修改成功!");
        document.getElementById("update").submit();
    }

</script>
<%
    Commodit commodit=(Commodit)request.getAttribute("commodit");
%>
<%@  include file="inbody.jsp"%>

    <!--中部-->
    <div class="center">
        <div class="center-top"><p>修改商品</p></div>
        <!--物品图片-->
         <div class="center-img">
              <img src="img/${commodit.image}" width="355px" height="350px">
         </div>

         <!--物品说明-->
         <div class="center-text">
             <br><br>
             <form action="updateDoCommodit.do" method="post" id="update">
                 <input type="text" name="sid" value="${commodit.sid}" hidden>
                 <input type="text" name="uid" value="${commodit.uid}" hidden>
            <p style="font-size: 20px;">&nbsp;商品名:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);"><input type="text" name="name" value="${commodit.name}"></span></p>
            <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;成色:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);"><input type="text" name="level" value="${commodit.level}"></span></p>
            <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;数量:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);"><input type="text" name="count" value="${commodit.count}"></span></p>
            <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;单价:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);"><input type="text" name="price" value="${commodit.price}"></span></p>
            <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;分类:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);"><input type="text" name="sort" value="${commodit.sort}"></span></p>
            <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;详细:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);"><input type="text" name="remark" value="${commodit.remark}" style="width: 200px"></span></p>
                 <p style="font-size: 20px;">&nbsp;&nbsp;&nbsp;图片:&nbsp;&nbsp;<span style="font-size: 16px;color: rgba(90, 90, 88, 0.918);"><input type="text" name="image" value="${commodit.image}"></span></p>
                <a href="javascript:update();"><input type="button" name="" value="修改" class="button"></a>
                 <br>
        </form>
         </div>
    </div>
</body>
</html>
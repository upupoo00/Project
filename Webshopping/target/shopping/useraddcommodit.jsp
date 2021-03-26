<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>校园二手市场主页</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/inhead.css" rel="stylesheet">
    <link href="css/useraddcommdit.css" rel="stylesheet">   
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/useraddcommdit.js"></script>
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
<script>
    function addcommodit(){
        alert("添加成功！")
        document.getElementById("addCommodit").submit();
    }
</script>
<body>
    <!--导航-->
    <%@  include file="inbody.jsp"%>
    
    <!--发布栏-->
    <div class="center-top"><p>发&nbsp;&nbsp;布&nbsp;&nbsp;商&nbsp;&nbsp;品</p>
        <span style="position: relative;">用户:<!--此处加登录用户名-->${user.username}</span></div>
        <div class="center">
            
         <form action="addCommodit.do" method="post" id="addCommodit">
             <table>
                  <tr>
                      <input name="uid" value="${user.uid}" hidden/>
                  </tr>
                 <tr>
                     <td><p class="center-p">商品名:&nbsp;&nbsp;&nbsp;</p></td>
                     <td><input type="text" placeholder="请输入商品名称" class="center-input" value="" name="name"></td>
                 </tr>

                 <tr>
                    <td><p class="center-p">成色:&nbsp;&nbsp;&nbsp;</p></td>
                    <td><select class="center-select" name="level" id="select">
                        <option spellcheck="true" selected></option>
                        <option>一成</option>
                        <option>二成</option>
                        <option>三成</option>
                        <option>四成</option>
                        <option>五成</option>
                        <option>六成</option>
                        <option>七成</option>
                        <option>八成</option>
                        <option>九成</option>
                        <option>全新</option>
                    </select></td>
                </tr>

                <tr>
                    <td><p class="center-p">单价:&nbsp;&nbsp;&nbsp;</p></td>
                    <td><input type="text" placeholder="请输入商品单价" class="center-input" value="" name="price">RMB</td>
                </tr>

                <tr>
                    <td><p class="center-p">数量:&nbsp;&nbsp;&nbsp;</p></td>
                    <td><input type="text" placeholder="请输入商品数量" class="center-input" value="" name="count"></td>
                </tr>

                <tr>
                    <td><p class="center-p">详细:&nbsp;&nbsp;&nbsp;</p></td>
                    <td><br><textarea placeholder="填写商品详情" name="remark"></textarea></td>
                </tr>

                <tr>
                    <td><p class="center-p">分类:&nbsp;&nbsp;&nbsp;</p></td>
                    <!--下拉列表-->
                    <td>           
                    <select class="center-select" name="" id="first" onChange="nextChange1()">
                        <option selected="selected"></option>
                        <option >数码科技</option>
                        <option>音影家电</option>
                        <option>鞋服配饰</option>
                        <option>图书文具</option>
                        <option>其他</option>
                    </select>--
                
                    <select class="center-select" id="second"  name="sort">
                    </select>
                </td>
                </tr>

                <tr>
                    <td><p class="center-p">图片:&nbsp;&nbsp;&nbsp;</p></td>
                    <td><input type="text" value="" name="image" id="img"  placeholder="格式:图片名.(jpg/png)" style="position:relative;margin-top: 20px;"></td>
                </tr>
                
                <tr>
                    <td colspan="2">
                        <a href="javascript:addcommodit();"><input type="button" value="提交" class="button1"></a>
                    </td>
                </tr>
             </table>
         </form>
        </div>
        
</body>
<%}%>
</html>
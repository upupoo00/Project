<%@ page import="com.shopping.dao.CommoditDao" %>
<%@ page import="com.shopping.dao.impl.CommoditDaoImpl" %>
<%@ page import="com.shopping.model.Commodit" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人主页</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/inhead.css" rel="stylesheet">
    <link href="css/userinformation.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
    <%
    User user=(User)request.getAttribute("user");
%>
<script>
    function update(){
        alert("修改成功!");
        document.getElementById("update").submit();
    }
</script>
<body>
<%@  include file="inbody.jsp"%>
<!--用户个人信息-->
<div class="center-top"><p>用&nbsp;&nbsp;户&nbsp;&nbsp;信&nbsp;&nbsp;息</p></div>
<div class="center">
    <form class="table" action="updateDoUsermanager.do" method="post" id="update">
        <table>
            <tr>
                <td style="width:800px;height: 40px;background-color: rgb(10, 83, 241);">
                    <p style="font-weight: 400;font-family: 微软雅黑;position: relative;margin-left: 20px;">用户名:${user.username}</p><input type="text" name="uid" value="${user.uid}" hidden/>
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 200px;background-color: white;">
                    <div style="color: rgb(79, 5, 177);font-weight: bolder;position: relative;margin-left: 250px;">
                        <span>用户名:<input type="text" name="username" value="${user.username}"/></span><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:update();"><input type="button" value="确认修改" style="background-color: rgb(79, 5, 177);color: white;font-weight: 400;border: 0;height: 30px;width: 100px;border-radius: 10px;"></a><br>
                    </div>
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 10px;background-color: white;">
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 40px;background-color: rgb(245, 243, 243);color:  rgb(129, 127, 127);border: 0.2px solid rgb(116, 114, 114);border-radius: 10px;">
                    <p style="font-weight: 550;font-family: 微软雅黑;position: relative;margin-left: 20px;">真实姓名:&nbsp;&nbsp;<input type="text" name="realname" value="${user.realname}" style="height: 50%;position: relative;top: 1px;" /></p>
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 10px;background-color: white;">
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 40px;background-color: rgb(245, 243, 243);color: rgb(129, 127, 127);border: 0.2px solid rgb(116, 114, 114);border-radius: 10px;">
                    <p style="font-weight: 550;font-family: 微软雅黑;position: relative;margin-left: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别:&nbsp;&nbsp;&nbsp;<input type="text" name="sex" value="${user.sex}" style="height: 50%;position: relative;top: 1px;" /></p>
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 10px;background-color: white;">
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 40px;background-color: rgb(245, 243, 243);color: rgb(129, 127, 127);border: 0.2px solid rgb(116, 114, 114);border-radius: 10px;">
                    <p style="font-weight: 550;font-family: 微软雅黑;position: relative;margin-left: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号:&nbsp;&nbsp;&nbsp;<input type="text" name="sno" value="${user.sno}" style="height: 50%;position: relative;top: 1px;" /></p>
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 10px;background-color: white;">
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 40px;background-color: rgb(245, 243, 243);color: rgb(129, 127, 127);border: 0.2px solid rgb(116, 114, 114);border-radius: 10px;">
                    <p style="font-weight: 550;font-family: 微软雅黑;position: relative;margin-left: 20px;">&nbsp;&nbsp;&nbsp;宿舍号:&nbsp;&nbsp;&nbsp;<input type="text" name="dormitory" value="${user.dormitory}" style="height: 50%;position: relative;top: 1px;" /></p>
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 10px;background-color: white;">
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 40px;background-color: rgb(245, 243, 243);color: rgb(129, 127, 127);border: 0.2px solid rgb(116, 114, 114);border-radius: 10px;">
                    <p style="font-weight: 550;font-family: 微软雅黑;position: relative;margin-left: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机:&nbsp;&nbsp;&nbsp;<input type="text" name="phone" value="${user.phone}" style="height: 50%;position: relative;top: 1px;" /></p>
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 40px;background-color: rgb(245, 243, 243);color: rgb(129, 127, 127);border: 0.2px solid rgb(116, 114, 114);border-radius: 10px;">
                    <p style="font-weight: 550;font-family: 微软雅黑;position: relative;margin-left: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码:&nbsp;&nbsp;&nbsp;<input type="text" name="password" value="${user.password}" style="height: 50%;position: relative;top: 1px;" /></p>
                </td>
            </tr>
            <tr>
                <td style="width:800px;height: 40px;background-color: rgb(245, 243, 243);color: rgb(129, 127, 127);border: 0.2px solid rgb(116, 114, 114);border-radius: 10px;">
                    <p style="font-weight: 550;font-family: 微软雅黑;position: relative;margin-left: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型:&nbsp;&nbsp;&nbsp;<input type="text" name="type" value="${user.type}" style="height: 50%;position: relative;top: 1px;" /></p>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

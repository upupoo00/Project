<%@ page import="com.shopping.model.User" %>
<%@ page import="com.shopping.service.UserService" %>
<%@ page import="com.shopping.service.impl.UserServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>校园二手市场管理员界面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/manager.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/shopping.js"></script>
</head>
<%
    User user1=(User)session.getAttribute("user");
    UserService us=new UserServiceImpl();
    List<User> list=new ArrayList<User>();
    int linecount=us.getUsercount();
    int pagecount=0;
    int start=0;
    String pagenow=request.getParameter("pagenow");
    if(pagenow!=null){
        start=Integer.parseInt(pagenow);
        //判断总页数
        if(linecount%5==0) {
            pagecount=linecount/5;
        }else {
            pagecount=linecount/5+1;
        }
        //判断是否到达尾页和首页
        if(Integer.parseInt(pagenow)<1) {
            list = us.getUserFy(1);
        }else if(Integer.parseInt(pagenow)>pagecount){
            list = us.getUserFy(pagecount);
        }else {
            list=us.getUserFy(Integer.parseInt(pagenow));
        }
    }else {
        start=1;
        list=us.getUserFy(1);
    }
%>
<body>
<!--导航-->
<div class="top">
    <div class="top-1">
        <ul class="nav nav-pills">
            <li style="border-bottom: 1px solid rgb(15, 15, 15);"><a href="manager.jsp">&nbsp;&nbsp;&nbsp;用户信息&nbsp;&nbsp;&nbsp;</a></li>
            <li style="border-bottom: 1px solid rgb(15, 15, 15);"><a href="managerCommodit.jsp">&nbsp;&nbsp;&nbsp;商品信息&nbsp;&nbsp;&nbsp;</a></li>
            <li style="border-bottom: 1px solid rgb(15, 15, 15);"><a href="Login.jsp">&nbsp;&nbsp;&nbsp;退出&nbsp;&nbsp;&nbsp;</a></li>
        </ul>
        <span style="position: relative;left: 600px;top: -30px;font-size: 23px;color: whitesmoke;">欢迎管理员:${user.username}</span>
    </div>
</div>
<!--中间部分-->
<div class="center">
    <div class="center-1">
              <span class="span1">
                 用户管理
              </span>
    </div>
    <div class="center-2">
        <span class="span2">用户名称:</span>
        <input type="text"  name="" style="width: 200px;height: 30px;position: relative;left: 350px;top: 7px;"/>
        <a href=""><input type="button" class="button1" value="搜索"/></a>
    </div>
    <div class="center-3">
        <div class="center3-1">
            <span class="span3">用户信息列表</span>
        </div>
        <div class="center3-2">
            <form>
                <table class="table1">
                    <thead>
                    <td>Id</td>
                    <td>用户名</td>
                    <td>手机</td>
                    <td>真实姓名</td>
                    <td>学号</td>
                    <td>宿舍号</td>
                    <td>性别</td>
                    <td>用户密码</td>
                    <td>用户类型</td>
                    <td>操作</td>
                    </thead>
                    <tbody>
                        <%
             for(int i=0;i<list.size();i++){
                 User user=list.get(i);
                 pageContext.setAttribute("user",user);
         %>
                    <tr>
                        <td>${user.uid}</td>
                        <td>${user.username}</td>
                        <td>${user.phone}</td>
                        <td>${user.realname}</td>
                        <td>${user.sno}</td>
                        <td>${user.dormitory}</td>
                        <td>${user.sex}</td>
                        <td>${user.password}</td>
                        <td>${user.type}</td>
                        <td>
                            <a href="updateToUsermanager.do?uid=${user.uid}" ><input type="button" class="button2" value="编辑"></a>
                            <a href="deleteUsermanager.do?uid=${user.uid}"><input type="button" class="button3" value="删除"></a>
                        </td>
                    </tr>
               <%}%>
                </table>
            </form>
        </div>
    </div>
    <div class="center-4">
        <a href="manager.jsp?pagenow=<%=1%>"><input type="button" class="button4" value="首页"/></a>
        <a href="manager.jsp?pagenow=<%=start-1%>"><input type="button"class="button4" value="上一页"/>
            <a href="manager.jsp?pagenow=<%=start+1%>"><input type="button" class="button4"value="下一页"/>
                <a href="manager.jsp?pagenow=<%=pagecount%>"><input type="button"class="button4" value="尾页"/>
    </div>
</div>
</body>
</html>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.invalidate(); //手动销毁session
%>
<jsp:forward page="index.jsp" />

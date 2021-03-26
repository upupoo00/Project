
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    String msg=(String)request.getAttribute("msg");
%>
<c:if test="${msg!=null}">
    ${msg}
</c:if>



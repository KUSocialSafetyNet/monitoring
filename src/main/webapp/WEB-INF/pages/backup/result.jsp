<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% Calendar calendar=Calendar.getInstance();%>

<html>
<%@include file="/WEB-INF/pages/header.jsp"%>
<body>
<table class = "rounded">
    <h2>Таблица результатов бэкапирования Базы Данных районов c FTP сервера ${host}<br> на дату <%=calendar.getTime()%></h2>
    <p>
    </p>
    <tr>
        <p><th>Название</th></p>
        <p><th>Day</th></p>
        <p><th>Week</th></p>
        <p><th>Month</th></p>
    </tr>
    <c:forEach items="${result}" var="user">
    <tr>
    <td class="noerror">${user.get("name")}</td>
    <td class="${user.get("DAYid")}">${user.get("DAY")}</td>
        <td class="${user.get("WEEKid")}">${user.get("WEEK")}</td>
        <td class="${user.get("MONTHid")}">${user.get("MONTH")}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>

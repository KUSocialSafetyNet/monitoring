<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.08.2018
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  ArrayList<HashMap> result=(ArrayList<HashMap>) request.getAttribute("result");
    for (HashMap hashMap : result) {
    %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<tr>
    <td><%=""+hashMap.get("name")+"     "+hashMap.get("folder")+"     "+hashMap.get("date")%></td><br>
<% }%>
</tr>

</body>
</html>

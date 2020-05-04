<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 5/4/2020
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rates</title>
</head>
<%
    Map<String, BigDecimal> rates = (Map<String, BigDecimal>) request.getAttribute("rates");
%>
<body>
The rate from :
<table>
    <thead>
    <tr>
        <th>Currency</th>
        <th>Rate</th>
    </tr>
    </thead>
    <tbody>
    <%
        Set<String> names = rates.keySet();
        for (String name : names) {
            BigDecimal rate = rates.get(name);
    %>
    <tr>
        <td><%= name%>
        </td>
        <td><%=rate%>
        </td>
    </tr>
    <%
        }
    %>

    </tbody>
</table>
</body>
</html>

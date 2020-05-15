<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 5/4/2020
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select currencies</title>
</head>
<body>
Select currencies to display the exchange rates:
<form action="${pageContext.request.contextPath}/rates">
    <%
        Set<String> codes = (Set<String>) request.getAttribute("codes");
    %>
    <table>
        <tr>
            <td>From:</td>
            <td>
                <select name="fromCode">
                    <%
                        for (String code : codes) {
                    %>
                    <option><%= code%></option>
                    <%
                        }
                    %>
                </select>
            </td>
            <td>To:</td>
            <td>
                <select name="toCodes" multiple="multiples" size="4">
                    <%
                        for (String code : codes) {
                    %>
                    <option><%= code%></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <input type="submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

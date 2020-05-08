<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert Amount</title>
</head>
<body>
<%
    Set<String> currencies = (Set<String>) request.getAttribute("currencies");
%>
<form action="/finance/convert" method="post">
    <table>
        <tr>
            <td>Currency From:</td>
            <td>
                <select name="from">
                    <%
                        for (String currency : currencies) {
                    %>
                    <option value="<%=currency%>"><%=currency%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </td>
            <td>Currency To:</td>
            <td>
                <select name="to">
                    <%
                        for (String currency : currencies) {
                    %>
                    <option value="<%=currency%>"><%=currency%>
                    </option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Amount:</td>
            <td><input type="number" step="0.001" name="amount"/></td>
        </tr>
        <tr>
            <td colspan="3"></td>
            <td>
                <button>Submit</button>
            </td>
        </tr>
    </table>
</form>
<% if (request.getAttribute("convertedAmount") != null) {%>
<table>
    <tr>
        <td>From:</td>
        <td><%=request.getParameter("from")%>
        </td>
        <td>To:</td>
        <td><%=request.getParameter("to")%>
        </td>
    </tr>
    <tr>
        <td colspan="4"><%=request.getParameter("amount")%> is <%= request.getAttribute("convertedAmount") %>
            With rate:<%= request.getAttribute("rate") %>
        </td>
    </tr>
</table>
<%}%>
</body>
</html>

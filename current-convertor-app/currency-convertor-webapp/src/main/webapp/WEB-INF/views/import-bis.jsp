<%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 5/9/2020
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Import BIS file</title>
</head>
<body>
<form method="post" action="/finance/importBIS" enctype="multipart/form-data">
    <table>
        <tr>
            <td>BIS file</td>
            <td><input name="bisFile" type="file"/></td>
        </tr>
        <tr>
            <td>Date</td>
            <td><input name="fileDate" type="date"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button>Import</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

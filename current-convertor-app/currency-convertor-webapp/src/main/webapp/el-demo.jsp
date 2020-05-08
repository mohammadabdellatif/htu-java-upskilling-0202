<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${empty param['name']}">
        Hello Anonymous
    </c:when>
    <c:otherwise>
        Hello, ${param['name']}
    </c:otherwise>
</c:choose>
, welcome to the website

</body>
</html>

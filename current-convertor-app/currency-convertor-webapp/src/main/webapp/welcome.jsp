<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%-- scriptlet definition --%>
<%!
    private String currentDate() {
        return LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    }
%>
<%-- scriplet --%>
<%
    String systemDate = currentDate();
%>
<%-- scriptlet expression --%>
Time on server: <%= systemDate%>

</body>
</html>

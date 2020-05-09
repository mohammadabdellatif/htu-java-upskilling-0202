<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Convert Amount</title>
   <link type="text/css" rel="stylesheet" href="/finance/css/app.css">
</head>
<body>
<form action="/finance/convert" method="post">
    <table>
        <tr>
            <td class="form-label">Currency From</td>
            <td>
                <select name="from">
                    <c:forEach items="${requestScope['currencies']}" var="currency">
                        <option value="${currency}">${currency}</option>
                    </c:forEach>
                </select>
            </td>
            <td class="form-label">Currency To</td>
            <td>
                <select name="to">
                    <c:forEach items="${requestScope['currencies']}" var="currency">
                        <option value="${currency}">${currency}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td class="form-label">Amount</td>
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

<c:if test="${not empty requestScope.convertedAmount}">
    <table>
        <tr>
            <td>From:</td>
            <td>${param.from}
            </td>
            <td>To:</td>
            <td>${param['to']}
            </td>
        </tr>
        <tr>
            <td colspan="4">${param.amount} is
                <fmt:formatNumber value="${requestScope.convertedAmount}" type="currency" currencyCode="${param.to}"/>
                With rate: ${requestScope.rate}
            </td>
        </tr>
    </table>
</c:if>

<c:if test="${not empty sessionScope.lastConvertRequest}">
    Last convert request:
    <table>
        <tr>
            <td>From:</td>
            <td>${sessionScope.lastConvertRequest.from}</td>
        </tr>
        <tr>
            <td>To:</td>
            <td>${sessionScope.lastConvertRequest.to}</td>
        </tr>
        <tr>
            <td>Amount:</td>
            <td>${sessionScope.lastConvertRequest.amount}</td>
        </tr>
    </table>
</c:if>

</body>
</html>

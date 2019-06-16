<%--
  Created by IntelliJ IDEA.
  User: ym
  Date: 19-5-17
  Time: 下午3:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
    <table align="center">
        <c:forEach items="${persons}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.sex}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

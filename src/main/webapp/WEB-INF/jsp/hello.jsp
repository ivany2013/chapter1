<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mysteel-xl
  Date: 2017/11/7
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1>111</h1>
<table>
    <tr>
    <td>名称</td>
    <td>联系人</td>
    <td>号码</td>
    <td>邮箱</td>
    <td>操作</td>
    </tr>

    <c:forEach var="customer" items="${list}">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.contact}</td>
            <td>${customer.telephone}</td>
            <td>${customer.email}</td>
            <td>${customer.remark}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

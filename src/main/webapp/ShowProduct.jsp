<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 10/01/2022
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1></h1>
<table border="1">
    <td><button class="bubble-legend-symbol"><a href="/create">Create</a></button></td>
    <c:forEach items="${products}" var="p" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${p.name}</td>
            <td><img src="${p.img}" width="200" height="150"></td>
            <td><button><a href="/edit?index=${loop.index}">edit</a></button></td>
            <td><button><a href="/delete?index=${loop.index}">delete</a></button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
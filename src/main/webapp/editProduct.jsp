<%--
  Created by IntelliJ IDEA.
  User: Admind
  Date: 10/01/2022
  Time: 11:21 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

<div class="col-2">
    <div class="form-container">
        <div class="form-btn">

            <span>Edit Product</span>
        </div>

        <form action="/edit" method="post">
            <input type="text" name="id" value="${p.id}">
            <input type="text" name="name" value="${p.name}">
            <input type="text" name="img" value="${p.img}">
            <button type="submit" class="btn">Register</button>
        </form>

    </div>
</div>

</body>
</html>

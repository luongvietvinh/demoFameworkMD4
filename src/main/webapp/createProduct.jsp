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
                        <span onclick="register()">create Product</span>
                        <hr id="Indicator">
                    </div>
                    <form  action="/create" method="post">

                       <p><input type="text"name="id" placeholder="id"> </p> <br>
                       <p><input type="text" name="name" placeholder="name"></p><br>
                        <p><input type="text" name="img" placeholder="img">
                            <button type="submit" class="btn">Register</button></p>
                    </form>

                </div>
            </div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Huy
  Date: 11/11/2022
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/login/login.css">
</head>
<body>
<div class="card" style="position: absolute; border-radius: 1.5%;">
    <div class="card-header">Please Sign In</div>
    <form action="${pageContext.request.contextPath}/login" method="post" name="login-form" id="login-form">
        <div class="form-group email">
            <input type="text" name="username" class="form-control" placeholder="Username"/>
        </div>

        <div class="form-group">
            <input type="text" name="password" class="form-control" placeholder="Password"/>
        </div>

        <div class="text-danger">${requestScope.message}</div>

        <div class="form-check">
            <input type="checkbox" class="form-check-input"/>
            <label class="form-check-label">Remember me</label>
        </div>

        <div class="form-button">
            <button type="submit" class="btn btn-success login">Login</button>
        </div>

        <div class="form-href">
            <a href="/member?action=createFormMember">Click here to Register</a>
        </div>
    </form>
</div>
</body>
</html>

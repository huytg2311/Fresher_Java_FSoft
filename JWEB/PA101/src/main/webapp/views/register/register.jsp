<%--
  Created by IntelliJ IDEA.
  User: Huy
  Date: 11/14/2022
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/register/register.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="card" style="position: absolute; border-radius: 1.5%;">
    <div class="card-header">Register</div>
    <form action="${pageContext.request.contextPath}/member?action=create" method="post">
        <div class="form-group email">
            <input type="text" name="username" class="form-control " placeholder="User name"/>
        </div>

        <div class="form-group">
            <input type="email" name="email" class="form-control exampleInputEmail1" placeholder="E-mail"/>
        </div>

        <div class="form-group">
            <input type="text" name="password" id="password" class="form-control exampleInputPassword1" placeholder="Password"/>
        </div>

        <div class="form-group">
            <input type="text" class="form-control exampleInputRePassword1" placeholder="Re-Password" required oninput="checkPasswordMatch(this)"/>
        </div>

        <div class="form-button">
            <button type="submit" class="btn btn-success register">Register</button>
        </div>

        <p class="text-success">${requestScope.message}</p>

        <div class="form-href">
            <a href="/login">Click here to login</a>
        </div>


    </form>
</div>
<script>
    function checkPasswordMatch(fieldConfirmPassword) {
        if (fieldConfirmPassword.value !== $("#password").val()) {
            fieldConfirmPassword.setCustomValidity("Passwords do not match!");
        } else {
            fieldConfirmPassword.setCustomValidity("");
        }
    }
</script>
</body>
</html>

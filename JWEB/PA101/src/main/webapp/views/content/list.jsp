<%--
  Created by IntelliJ IDEA.
  User: Huy
  Date: 11/13/2022
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/content/list.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand">
        CMS
    </a>

    <div class="btn-group">

        <button type="button" class="dropdown-toggle bi bi-person-fill" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false"></button>
        <div class="dropdown-menu dropdown-menu-right">
            <a class="dropdown-item bi bi-person-fill" type="button" href="/member?action=showEditForm&username=${usernameSS}"> User Profile</a>
            <a class="bi bi-arrow-right-square-fill dropdown-item " type="button" href="/logout"> Logout</a>
        </div>
    </div>
</nav>

<nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse bg-light">
    <div class="position-sticky">

        <nav class="list-group-item navbar navbar-light bg-light">
            <form class="form-inline">
                <input class="form-control mr-sm-2 inputSearch" type="search" placeholder="Search" aria-label="Search" id="searchValue" oninput="search()">
                <button class="btn btn-secondary my-2 my-sm-0 bi bi-search buttonSearch" type="submit"></button>
            </form>
        </nav>

        <a href="/content?action=list" id="view-contents" class="bi bi-grid-3x3 bg-light list-group-item  py-2 ripple"
           aria-current="true">
            View contents
        </a>
        <a href="/content?action=create" class="bi bi-pencil-square bg-light list-group-item  py-2 ripple"
           aria-current="true">
            Form content
        </a>
        <a class="bg-light"></a>

    </div>

</nav>
<div id="content-main">
    <div class="title">
        <h2>View Content</h2>
    </div>
    <div class="card" style="position: absolute">
        <table class="table table-bordered table-content" style="width: 90%;">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Brief</th>
                <th class="last-th" scope="col">Created Data</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="content" items="${listContent}">
                <tr>
                    <td>${content.id}</td>
                    <td>${content.title}</td>
                    <td>${content.brief}</td>
                    <td>${content.create_date}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>

<script>
    function search() {
        let id = $("#searchValue").val();

        $.ajax({
            type: "GET",
            url: "/content?search=" + id,
            dataType: "HTML",
            success: function (data) {
                $("#table-content").html(data)
            }
        })
    }
</script>
</html>

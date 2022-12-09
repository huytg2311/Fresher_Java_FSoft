<%--
  Created by IntelliJ IDEA.
  User: Huy
  Date: 11/13/2022
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/views/content/add.css">
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

        <button type="button" class="dropdown-toggle bi bi-person-fill" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></button>
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
                <input class="form-control mr-sm-2 inputSearch" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-secondary my-2 my-sm-0 bi bi-search buttonSearch" type="submit"></button>
            </form>
        </nav>

        <a href="/content?action=list" id="view-contents" class="bi bi-grid-3x3 bg-light list-group-item  py-2 ripple" aria-current="true">
            View contents
        </a>
        <a href="/content?action=create" class="bi bi-pencil-square bg-light list-group-item  py-2 ripple" aria-current="true">
            Form content
        </a>
        <a class="bg-light"></a>

    </div>

</nav>

<!-- content -->
<div id="content-main">
    <div class="title">
        <h2>Add Content</h2>
    </div>
    <div id="wait" style="display:none;width:69px;height:89px;border:1px solid black;position:absolute;top:50%;left:50%;padding:2px;"><img src='demo_wait.gif' width="64" height="64" /><br>Loading..</div>
    <div class="card" style="position: absolute">
        <div class="card-header">Content Form Elements</div>
        <form class="form-content" action="/content?action=create" method="post">
            <input type="hidden" name="id">
            <div class="form-group firstName">
                <label>Title</label>
                <input type="text" name="title" class="form-control" placeholder="Enter the title"/>
            </div>

            <div class="form-group">
                <label>Brief</label>
                <textarea type="text" name="brief" class="form-control"></textarea>

            </div>

            <div class="form-group">
                <label>Content</label>
                <textarea type="text" name="content" class="form-control"></textarea>

            </div>

            <div class="button-submit">
                <button class="submit">Submit Button</button>
                <button class="reset">Reset Button</button>
            </div>

        </form>
    </div>
</div>
</body>
</html>

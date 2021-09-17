<%--
  Created by IntelliJ IDEA.
  User: eliasguajardo
  Date: 9/15/21
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/partials/head.jsp">
        <jsp:param name="title" value="Update Profile For Our Site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/partials/navbar.jsp" />
<div class="container">
    <h1>Please fill in your information.</h1>
    <form action="/update" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" value="${userUpdate.username}" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text" value="${userUpdate.email}">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password">
        </div>
        <button type="submit"
                name="UpdateProfileButton"
                class="btn btn-primary ml-auto"
                value="${sessionScope.user.id}"
        >Update My Account</button>
    </form>
</div>
</body>
</html>

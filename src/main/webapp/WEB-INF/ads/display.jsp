<%--
  Created by IntelliJ IDEA.
  User: johnmccloskey
  Date: 9/14/21
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>ADS</title>
</head>
<body>
<h1>Display Ad here!!!</h1>

    <div class="col-md-6">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
        <p>${user.username}</p>
        <p>${user.email}</p>
    </div>

</body>
</html>

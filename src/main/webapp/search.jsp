<%--
  Created by IntelliJ IDEA.
  User: johnmccloskey
  Date: 9/20/21
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Search Ad Here!</title>
    <jsp:include page="/WEB-INF/partials/navbar.jsp">
        <jsp:param name="title" value="Search Results" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Results for: <c:out value="${keywords}"/></h1>
    <c:forEach var="ad" items="${foundAds}">
    <div class="col-md-6">
        <a href="/ad-info/show?id=${ad.id}"><h2><c:out value="${ad.title}"/></h2></a>
        <p><c:out value="${ad.description}"/></p>
    </div>
    </c:forEach>
</body>
</html>

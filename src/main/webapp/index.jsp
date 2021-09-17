<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to your ADS!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Adlister...lister of ADS!</h1>

        <c:forEach var="ad" items="${ads}">
          <div class="col-md-6">
            <a href="${pageContext.request.contextPath}/ads/display?id=${ad.id}">
                <h1>${ad.title}</h1>
            </a>
              <p>${ad.description}</p>
          </div>
        </c:forEach>
    </div>
</body>
</html>

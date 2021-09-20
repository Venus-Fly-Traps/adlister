<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Delete Ad Ad" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
  <h1>Delete Current Ad</h1>
  <form action="/ads/deletead" method="post">
    <input id="id" name="id" value="${id}" class="form-control" type="hidden">

    <button type="submit" class="btn btn-block btn-primary" name="deleteButton">Delete Record</button>
  </form>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="UpDate Ad" />
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
  <h1>Update Current Ad</h1>
  <form action="/ads/update" method="post">
      <input id="id" name="id" value="${adtoUpdate.id}" class="form-control" type="hidden">
    <div class="form-group">
      <label for="title">Title</label>
      <input id="title" name="title" class="form-control" type="text" value="${adtoUpdate.title}">
    </div>
    <div class="form-group">
      <label for="description">Description</label>
      <textarea id="description" name="description" class="form-control" type ="text">${adtoUpdate.description}</textarea>
    </div>
    <button type="submit" class="btn btn-block btn-primary" name="deleteButton">Update Record</button>
  </form>
</div>
</body>
</html>
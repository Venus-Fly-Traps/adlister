<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li>class= "nav-item" style= "padding-top: 10px">
            <form>action"/ad/search" method"post" class="form-inline">
            <input class="form-control mr-sm-2 my-sm-0" name="search" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
            </li>
            <li><a href="/login">Login</a></li>
    <c:choose>
        <c:when test="${sessionScope.user!=null}">
            <li><a href="/profile">Profile</a></li>
            <li><a href="/ads/create">Create Ad</a></li>
            <li><a href="/logout">Logout</a></li>git
            <li><a href="/search">Search</a></li>
        </c:when>
    <c:otherwise>
            <li><a href="/login">Login</a> </li>
            <li><a href="/search">Search</a></li>
    </c:otherwise>
    </c:choose>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

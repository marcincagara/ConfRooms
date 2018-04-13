<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Welcome!</h1>

<div class="main">
    <div class="main-menu">
        <ul>
            <li><a href="/about">About</a></li>
            <li><a href="/conf">Conf Room Panel</a></li>
            <li><a href="/admin">Admin Panel</a></li>
            </br>
            <li>
            <form:form action="${pageContext.request.contextPath}/logout" method="GET">
                <input type="submit" value="Logout">
            </form:form>
            </li>
        </ul>
    </div>
</div>

</body>
</html>

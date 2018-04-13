<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 22/03/2018
  Time: 01:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Login page</title>
    <h2>Login page</h2>
<style>
    .failed{
        color:red;
    }

</style>
</head>
<body>
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
        <c:if test="${param.error != null}">

            <i class="failed">Sorry! You entered invalid username/password.</i>
        </c:if>

        <p>
            User name: <input type="text" name = "username" />
        </p>
        <p>
            Password: <input type="text" name = "password" />
        </p>
        <input type="submit" value="Login"/>
    </form:form>

</body>
</html>

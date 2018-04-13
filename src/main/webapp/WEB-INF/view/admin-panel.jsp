<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 22/03/2018
  Time: 01:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
    <h2>Admin panel </h2>

</head>
<body>
<input type="button" value="Conf Room Panel"
       onclick="window.location.href='conf';return false;"
       class="add-button">
<security:authorize access="hasRole('ADMIN')">
<input type="button" value="User Panel"
       onclick="window.location.href='admin/showUser';return false;"
       class="add-button">
</security:authorize>
   <form:form action="${pageContext.request.contextPath}/logout" method="post">
       <input type="submit" value="logout">
   </form:form>
</body>
</html>

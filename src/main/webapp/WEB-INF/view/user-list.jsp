<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css"
          rel="stylesheet"
          href=${pageContext.request.contextPath}/resources/css/style.css />
</head>
<body>

<div id="wrapper">
    <div id ="header">
        <h2>ConfRoom - admin panel </h2>
    </div>
</div>
<div id = "container" >
    <div id="content">
        <table>
            <tr>
                <th>Login</th>
                <th>Email</th>
                <th>User Roles</th>
                <th>Enabled</th>
            </tr>
            <!-- put new button: Add user -->
            <input type="button" value="Add user"
                   onclick="window.location.href='saveUser';return false;"
                   class="add-button">

            <jsp:useBean id="userList" scope="request" type="java.util.List"/>
            <c:forEach var="tempUser" items="${userList}">

                              <tr>
                    <td>${tempUser.userName}</td>
                    <td>${tempUser.email}</td>
                    <td>${tempUser.userRoles}</td>
                    <td>${tempUser.enabled}</td>
                    <td><a href="/updateUser?userId=${tempUser.userId}" class="btn btn-danger">Update</a>
                        /

                        <form:form action="/deleteUser?userId=${tempUser.userId}"  method="DELETE">
                            <button onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false" type="submit" class="btn btn-danger">DELETE</button>

                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
    <a href="${pageContext.request.contextPath}/admin">Back to List</a>

</div>
<br><br>

</body>
</html>

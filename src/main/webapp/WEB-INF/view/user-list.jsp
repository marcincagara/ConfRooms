<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

            </tr>
            <!-- put new button: Add user -->
            <input type="button" value="Add user"
                   onclick="window.location.href='saveUser';return false;"
                   class="add-button">

            <jsp:useBean id="userList" scope="request" type="java.util.List"/>
            <c:forEach var="tempUser" items="${userList}">
                <c:url var="updateLink" value="/conf/updateUser" >
                    <c:param name="userId" value="${tempUser.id}" />

                </c:url>
                <c:url var="deleteLink" value="/conf/deleteUser" >
                    <c:param name="userId" value="${tempUser.id}" />

                </c:url>
                <tr>
                    <td>${tempUser.login}</td>


                    <td><a href = ${updateLink}>Update </a>
                        /
                        <a href = "${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
    <a href="${pageContext.request.contextPath}/conf/admin">Back to List</a>

</div>
<br><br>

</body>
</html>

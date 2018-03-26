<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">>
<head>
    <title>Title</title>
    <link type="text/css"
          rel="stylesheet"
          href=${pageContext.request.contextPath}/resources/static/css/style.css />
</head>
<body>

<div id="wrapper">
    <div id ="header">
        <h2>ConfRoom - admin panel </h2>
    </div>
</div>
<div id = "container" >
    <div id="content">


        <!-- put new button: Add confRoom -->
        <input type="button" value="Add confRoom"
                onclick="window.location.href='saveConf';return false;"
                    class="add-button">
        <table>
            <tr>
                <th>floor</th>
                <th>hdmi</th>
                <th>instruction</th>
                <th>labels</th>
                <th>lan</th>
                <th>name</th>
                <th>remotes</th>
                <th>skypeVc</th>
                <th>comments</th>

            </tr>

            <th:bean id="confRoomModel" scope="request" type="java.util.List"/>
            <th:each ="tempconfRoomModel" items="${confRoomModel}">
                <c:url var="updateLink" value="/conf/update" >
                    <c:param name="confRoomId" value="${tempconfRoomModel.id}" />

                </c:url>
                <c:url var="deleteLink" value="/conf/delete" >
                    <c:param name="confRoomId" value="${tempconfRoomModel.id}" />

                </c:url>
                <tr>
                    <td>${tempconfRoomModel.floor}</td>
                    <td>${tempconfRoomModel.hdmi}</td>
                    <td>${tempconfRoomModel.instruction}</td>
                    <td>${tempconfRoomModel.labels}</td>
                    <td>${tempconfRoomModel.lan}</td>
                    <td>${tempconfRoomModel.name}</td>
                    <td>${tempconfRoomModel.remotes}</td>
                    <td>${tempconfRoomModel.skypeVc}</td>
                    <td>${tempconfRoomModel.comments}</td>

                    <td><a href = ${updateLink}>Update </a>
                        /
                        <a href = "${deleteLink}"
                           onclick="if (!(confirm('Are you sure you want to delete this confRoom?'))) return false">Delete</a>
                    </td>
                </tr>
            </th:each>
        </table>

    </div>

</div>
<br><br>
</div>
<a href="${pageContext.request.contextPath}/conf/admin">Back to Home</a>

</div>
</body>
</html>

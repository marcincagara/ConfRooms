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


        <!-- put new button: Add confRoom -->
        <input type="button" value="Add confRoom"
                onclick="window.location.href='conf/saveConf';return false;"
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

            <jsp:useBean id="confRoomModel" scope="request" type="java.util.List"/>
            <c:forEach var="tempconfRoomModel" items="${confRoomModel}">
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

                    <td><a href="/conf/update?confRoomId=${tempconfRoomModel.id}" class="btn btn-danger">Update</a>
                        /
                        <form:form action="/conf/delete?confRoomId=${tempconfRoomModel.id}"  method="DELETE">
                            <button onclick="if (!(confirm('Are you sure you want to delete this confRoom?'))) return false" type="submit" class="btn btn-danger">DELETE</button>


                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>

</div>
<br><br>
</div>
<a href="${pageContext.request.contextPath}/admin">Back to List</a>

</div>
</body>
</html>

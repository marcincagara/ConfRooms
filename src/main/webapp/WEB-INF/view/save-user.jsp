<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save ConfRoom</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
    <style>
        .error{color:red}
    </style>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>ConfRoom - admin panel </h2>
    </div>
</div>

<div id="container">
    <h3>Save ConfRoom</h3>
    <%--@elvariable id="user" type="hello"--%>
    <form:form action="saveUser" modelAttribute="user" method="POST">

        <!-- need to associate this data with customer id -->
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>Login:</label></td>
                <td><form:input path="login"/></td>

            </tr>
            <tr>
                <td><label>Password:</label></td>
                <td><form:input path="password"/></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <div style="clear: both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/conf/showUser">Back to List</a>
    </p>
</div>
</body>
















</html>

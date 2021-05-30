<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee Pannel</title>
</head>
<body>

<h3>Employee Pannel</h3>
Welcome ${sessionScope.userfunction }
<br>
<a href="${pageContext.request.contextPath }/account/logout">Logout</a>

<div align="center">
    <table class="table table-striped table-bordered">

        <tr>
            <th>Employee ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Town</th>
            <th>Action</th>
        </tr>

        <c:forEach var="employee" items="${listEmployees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.email}</td>
                <td>${employee.phone}</td>
                <td>${employee.town}</td>
                <td>Action</td>
            </tr>

        </c:forEach>
    </table>
</div>

</body>
</html>
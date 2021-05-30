<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <title>Employee Form</title>
</head>
<body>
<div align="center">
    <br/>
    <h1>Employee Form</h1>
    <br/><br><br />
    <div>
        <form:form action="saveEmployee"
                   method="post" modelAttribute="employee">

            <form:hidden path="id" />

            <div class="form-group">
                <label for="firstName" >First Name</label>
                <div >
                    <form:input path="firstName" />
                </div>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <div >
                    <form:input path="lastName" />
                </div>
            </div>

            <div class="form-group">
                <label for="email" >Email</label>
                <div >
                    <form:input path="email" />
                </div>
            </div>

            <div class="form-group">
                <label for="phone" >Phone</label>
                <div >
                    <form:input path="phone" />
                </div>
            </div>

            <div class="form-group">
                <label for="town" >Town</label>
                <div >
                    <form:input path="town"/>
                </div>
            </div>

            <div class="form-group">
                <div >
                    <form:button >Submit</form:button>
                </div>
            </div>

        </form:form>
    </div>
</div>
</body>
</html>
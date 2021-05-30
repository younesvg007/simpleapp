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
    <title>Adding Employee</title>
</head>
<body>
<div align="center">
    <br/>
    <h1>Employee Form</h1>
    <br/>
    <div class="panel-body">
        <form:form action="saveEmployee" cssClass="form-horizontal"
                   method="post" modelAttribute="employee">

            <!-- need to associate this data with customer id -->
            <form:hidden path="id" />

            <div class="form-group">
                <label for="firstName" class="col-md-3 control-label">First
                    Name</label>
                <div class="col-md-9">
                    <form:input path="firstName" cssClass="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label for="lastName" class="col-md-3 control-label">Last
                    Name</label>
                <div class="col-md-9">
                    <form:input path="lastName" cssClass="form-control" />
                </div>
            </div>

            <div class="form-group">
                <label for="email" class="col-md-3 control-label">Email</label>
                <div class="col-md-9">
                    <form:input path="email" cssClass="form-control" />
                </div>
            </div>

            <div class="form-group">
                <label for="phone" class="col-md-3 control-label">Phone</label>
                <div class="col-md-9">
                    <form:input path="phone" cssClass="form-control" />
                </div>
            </div>

            <div class="form-group">
                <label for="town" class="col-md-3 control-label">Town</label>
                <div class="col-md-9">
                    <form:input path="town" cssClass="form-control" />
                </div>
            </div>

            <div class="form-group">

                <div class="col-md-offset-3 col-md-9">
                    <form:button cssClass="btn btn-primary">Submit</form:button>
                </div>
            </div>

        </form:form>
    </div>
</div>
</body>
</html>
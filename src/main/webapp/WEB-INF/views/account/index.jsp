<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login Page</title>
</head>
<body>
<div align="center" >
    <h3>Login Page</h3>
    ${msgError }
    <form method="post"
          action="${pageContext.request.contextPath }/account/login">
        <table border="0" cellpadding="2" cellspacing="2">
            <tr>
                <td>Username</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Login"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

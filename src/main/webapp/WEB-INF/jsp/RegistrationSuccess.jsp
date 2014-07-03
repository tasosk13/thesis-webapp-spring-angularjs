<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
</head>
<body>
    <div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Registration Succeeded.</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>Here's the review of your details:</h3>
                </td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${userForm.name}</td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td>${userForm.surname}</td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td>${userForm.email}</td>
            </tr>
            <tr>
                <td>UserName:</td>
                <td>${userForm.username}</td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>${userForm.password}</td>
            </tr>
 
        </table>
    </div>
</body>
</html>
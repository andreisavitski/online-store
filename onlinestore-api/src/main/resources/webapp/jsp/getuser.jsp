<%@ page import="java.util.*"%>
<%@ page import="by.pvt.onlinestore.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Info</title>
    <style>
            .container
            h1{
                font-family: 'Times New Roman', Times, serif;
                font-size:      30px;
                font-weight:    bold;
            }
            p{
                font-family: 'Times New Roman', Times, serif;
                font-size:      20px;
                font-weight:    bold;
            }
            b{
                font-family: 'Times New Roman', Times, serif;
                font-size:      20px;
                font-weight:    bold;
            }
            a{
                font-family: 'Times New Roman', Times, serif;
                font-size:      20px;
                font-weight:    bold;
            }
    </style>
</head>
<br>
<a href = "admin">Come back</a>
<body>
    <ul>
        <p><c:out value="Information about the user <${user.login}>: Full name: ${user.fullName} Role: ${user.role}" /></p>
    </ul>
</body>
</html>
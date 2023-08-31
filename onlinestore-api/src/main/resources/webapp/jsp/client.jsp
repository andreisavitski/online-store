<%@ page import="java.util.*"%>
<%@ page import="by.pvt.onlinestore.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CLIENT</title>
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
                font-size:      40px;
                font-weight:    bold;
            }
            a{
                font-family: 'Times New Roman', Times, serif;
                font-size:      20px;
                font-weight:    bold;
            }
            c:out{
                font-family: 'Times New Roman', Times, serif;
                font-size:      40px;
                font-weight:    bold;
            }
            .button1 {
              background-color: white;
              color: blue;
              border: 2px solid #4CAF50;
              font-family: 'Times New Roman', Times, serif;
              font-size:      20px;
              font-weight:    bold;
            }
            .button1:hover {
              background-color: #4CAF50;
              color: white;
            }
    </style>
</head>
<body>
<b>Hello </b1>
<c:out value = "${user.fullName}"/>
<br>
<a href = "login">LogOut</a>
<form method="get"
      action="/getproducts"
      accept-charset="utf-8">
    <div>
        <hr>
        <button class="button1" type="submit">Show all products</button>
    </div>
</form>
<form method="post"
      action="/addorder"
      accept-charset="utf-8">
    <div>
        <hr>
        <button class="button1" type="submit">Go shopping</button>
    </div>
</form>
<form method="get"
      action="/getorder"
      accept-charset="utf-8">
      <hr>
      <div>
      <input type="hidden" name="id" value="${user.id}">
      <button class="button1" type="submit">View all your orders</button>
      <hr>
    </div>
</form>
</body>
</html>
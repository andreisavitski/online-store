<%@ page import="java.util.*"%>
<%@ page import="by.pvt.onlinestore.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register form</title>
    <style>
            .container
            h1{
                font-family: 'Times New Roman', Times, serif;
                font-size:      40px;
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
            .image-button {
                width: 205px;
                height: 55px;
                border: none;
                background-image: url('image/register.jpg');
                background-size: cover;
            }
            .image-button1 {
                            width: 150px;
                            height: 55px;
                            border: none;
                            background-image: url('image/signIn.jpg');
                            background-size: cover;
                        }
    </style>
</head>
<body>
<form method="post"
    action="/register"
    accept-charset="utf-8">
    <div align="center" class="container">
    <h1>Registration</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label><b>Login</b></label>
    <input type="text" placeholder="Enter login" name="login">

    <label><b>Password</b></label>
    <input type="text" placeholder="Enter Password" name="password">

    <label><b>Name</b></label>
    <input type="text" placeholder="Enter name" name="name">

    <label><b>Surname</b></label>
    <input type="text" placeholder="Enter surname" name="surname">
    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
    <button class="image-button"></button>
    </div>
    <hr>
    <hr>
</form>
<form method="post"
     action="/authorize"
     accept-charset="utf-8">
     <div align="center" class="container">
     <h1>Authorization</h1>
     <p>Sign in if you have an account.</p>
     <hr>
     <label><b>Login</b></label>
     <input type="text" placeholder="Enter login" name="login">

     <label><b>Password</b></label>
     <input type="text" placeholder="Enter Password" name="password">
     <hr>
     <button class="image-button1"></button>
     </div>
</body>
</html>
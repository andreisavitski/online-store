<%@ page import="java.util.*"%>
<%@ page import="by.pvt.onlinestore.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ADMIN</title>
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
<b>Hello admin</b1>
<br>
<a href = "login">LogOut</a>
<body>
<form method="get"
    action="getusers"
    accept-charset="utf-8">
    <div>
    <hr>
    <label><b>View all users </b></label>
    <button type="submit">Show all clients</button>
    </div>
    </form>
<form method="post"
     action="getuser"
     accept-charset="utf-8">
     <div>
     <hr>
     <label><b>Viewing user information </b></label>
     <input type="text" placeholder="Enter login" name="login">
     <button type="submit">Look</button>
     </div>
     </form>
<form method="get"
     action="getproducts"
     accept-charset="utf-8">
     <div>
     <hr>
     <label><b>View information on all products </b></label>
     <button type="submit">Look</button>
     <hr>
     </div>
     </form>
<form method="post"
     action="addproduct"
     accept-charset="utf-8">
     <div>
     <label><b>Name</b></label>
     <input type="text" placeholder="Enter name" name="name">

     <label><b>Sku</b></label>
     <input type="text" placeholder="Enter sku" name="sku">

     <label><b>Type</b></label>
     <input type="text" placeholder="Enter type" name="type">

     <label><b>Description</b></label>
     <input type="text" placeholder="Enter description" name="description">

     <label><b>Price</b></label>
     <input type="text" placeholder="Enter price" name="price">

     <label><b>Quantity</b></label>
     <input type="text" placeholder="Enter quantity" name="quantity">
     <button type="submit">Add product</button>
     <hr>
     </div>
     </form>
<form method="post"
     action="changeproduct"
     accept-charset="utf-8">
     <div>
     <label><b>ID</b></label>
     <input type="text" placeholder="Enter ID" name="id">

     <label><b>Name</b></label>
     <input type="text" placeholder="Enter name" name="name">

     <label><b>Sku</b></label>
     <input type="text" placeholder="Enter sku" name="sku">

     <label><b>Type</b></label>
     <input type="text" placeholder="Enter type" name="type">

     <label><b>Description</b></label>
     <input type="text" placeholder="Enter description" name="description">

     <label><b>Price</b></label>
     <input type="text" placeholder="Enter price" name="price">

     <label><b>Quantity</b></label>
     <input type="text" placeholder="Enter quantity" name="quantity">
     <button type="submit">Change product</button>
     <hr>
     </div>
     </form>
<form method="post"
     action="getproduct"
     accept-charset="utf-8">
     <div>
     <label><b>Viewing product information </b></label>
     <input type="text" placeholder="Enter ID" name="id">
     <button type="submit">Look</button>
     <hr>
     </div>
     </form>
<form method="get"
      action="/getproducts"
      accept-charset="utf-8">
      <div>
      <label><b>Viewing all products </b></label>
      <button type="submit">Show all products</button>
      <hr>
    </div>
</form>
<form method="get"
      action="/getorders"
      accept-charset="utf-8">
      <div>
      <label><b>Viewing all orders </b></label>
      <button type="submit">Show all orders</button>
      <hr>
    </div>
</form>
<form method="get"
      action="/getorder"
      accept-charset="utf-8">
      <div>
      <label><b>View orders by user ID </b></label>
       <input type="text" placeholder="Enter ID" name="id">
      <button type="submit">Show orders</button>
      <hr>
    </div>
</form>
</body>
</html>
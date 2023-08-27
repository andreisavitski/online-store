<%@ page import="java.util.*"%>
<%@ page import="by.pvt.onlinestore.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products Info</title>
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
            }.button {
               background-color: #4CAF50; /* Green */
               border: none;
               color: white;
               padding: 15px 32px;
               text-align: center;
               text-decoration: none;
               display: inline-block;
               font-size: 16px;
             }
    </style>
</head>
<br>
<body>
<a href = "client">Exit to main menu</a>
<form method="get"
      action="getproducts"
      accept-charset="utf-8">
    <div>
        <hr>
        <button class="button1" type="submit">Show all products</button>
    </div>
    <hr>
</form>
    <c:forEach var="product" items="${products}">
    <p><c:out value="NAME: ${product.name} PRICE: ${product.price}byn " /></p>
<form method="post"
    action="basketadd"
    accept-charset="utf-8">
    <div>
    <input type="hidden" name="product" value="<c:out value="${product.productId}"/>">
    <input type="hidden" name="order" value="<c:out value="${order.id}"/>">
    <label><b>Quantity</b></label>
    <input type="text" placeholder="Enter quantity" name="quantity" required>
    <button>Add to Basket</button>
    <hr>
    </div>
    </form>
    </c:forEach>
<form method="post"
      action="completion"
      accept-charset="utf-8">
    <div>
        <button class="button" type="submit">Complete shopping and create an order</button>
        <input type="hidden" name="order" value="<c:out value="${order.id}"/>">
    </div>
    <hr>
</form>
</body>
</html>
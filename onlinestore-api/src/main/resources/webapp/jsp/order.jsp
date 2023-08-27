<%@ page import="java.util.*"%>
<%@ page import="by.pvt.onlinestore.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order</title>
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
    <hr>
    <p><c:out value="Order number: ${order.id}" /></p>
    <p><c:out value="Status: ${order.status}" /></p>
    <table>
          <tr>
            <td>
            <c:forEach var="product" items="${order.products}">
                <p><c:out value="Name: ${product.name}" /></p>
            </c:forEach>
            </td>
            <td>
            <c:forEach var="basket" items="${order.baskets}">
                <p><c:out value="Quantity: ${basket.quantityOfGoods}" /></p>
            </c:forEach>
            </td>
          </tr>
        </table>
    <p><c:out value="Total Cost: ${order.totalCost} byn" /></p>
    <hr>
<form method="post"
     action="create"
     accept-charset="utf-8">
     <div>
     <button type="submit">Create an order</button>
     <input type="hidden" name="order" value="<c:out value="${order.id}"/>">
     </div>
     </form>
</body>
</html>
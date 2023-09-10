<%@ page import="java.util.*"%>
<%@ page import="by.pvt.onlinestore.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage = "true"%>
<html>
<div>
<c:out value= "${errorMessage}"/>
<br>
<button onclick='history.back()'>Come back</button>
<br>
Go to a login page <a href = "login">To login</a>
</div>
</html>
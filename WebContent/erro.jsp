<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" import="java.io.*" contentType="text/plain"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro!</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="logo.jsp" %>
<%@ include file="menu.jsp" %>
<div class="container">
<h1>Ops! Use corretamente o sistema.</h1>
<br>
Message:
<p>Exception stack trace:<% exception.printStackTrace(response.getWriter()); %>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
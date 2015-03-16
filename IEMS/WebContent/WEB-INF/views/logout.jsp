<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Logout Page</title>
</head>
<body bgcolor="lightyellow">
<center>
        <%
            session.invalidate();
        %>
<h1>Logout was done successfully....</h1>
<h4> Click Hear to <a href="index.html">Login</a> again</h4>
</center>
</body>
</html>
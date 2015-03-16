<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>

</head>
<body>
<a href="edit">Edit</a>
<div id=container align="justify">
<div id=image align="left">
<img height="100px" width="100px" alt="" src="#" /> 
</div>
<div id=content1>
<label>First Name</label><label>${pro1.firstname}</label><br>
<label>Last Name</label><label>${pro1.lastname}</label><br>
<label>Date Of Birth</label><label>${emp1.dob}</label><br>
<label>Passport</label><label>${emp1.passport}</label><br>
</div>
<div id=content2>
<label>Summary</label><p>${emp1.summary}</p><br>
<label>Skills</label>
<%-- <table>${}</table> --%>
<br> --%>
<label>Education</label>
<table border="2"cellpadding="2" cellspacing="2"align="center">
<tr align="center">
<th>Degree</th><th>University</th><th>Year</th>
</tr>
<c:forEach items="${edu}" var="edu1">
 <tr align="center">

<c:forTokens items="${edu1.degree}" delims="," var="edu2">

<td>
<c:out value="${edu2}"></c:out>
</td>

</c:forTokens>
</tr>
</c:forEach>



</table><br>
<label>Experience</label>
<table border="2"cellpadding="2" cellspacing="2" align="center">
<tr align="center">
<th>Organization</th><th>Designation</th><th>Start Date</th><th>End Date</th>
</tr>
<c:forEach items="${exp}" var="exp1">
 
<tr align="center">

<c:forTokens items="${exp1.organization}" delims="," var="exp2">

<td>
<c:out value="${exp2}"></c:out>
</td>

</c:forTokens>
</tr>
</c:forEach>
</table><br>
</div>
</div>

</body>
</html>
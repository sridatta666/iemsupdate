<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Designation page</title>
	</head>
	<body>
		<h2 align="left">Designations are</h2>
		<form:form  method="POST" action="saveDesignation.html" commandName="designations" name="fm">
	   		<table bgcolor="pink" cellpadding="2">
	   		
	   	<tr>
           		<td><form:label path="designationid">Designation Id:</form:label></td>
           		<td><form:input path="designationid" readonly="true"
						value="${emp.designationid}" /></td>
       	</tr>
	   		
	   	<tr>
           		<td><form:label path="designationname">Designation Name:</form:label></td>
           		<td><form:input path="designationname" required="required" value="${emp.designationname}"/></td>
       </tr>
	    <tr>
			      <td colspan="2"><input type="submit" value="AddDesignations"/></td>
		      </tr>
			</table> 
		
		</form:form>
<table>
<tr>
	<th>DesignationID</th>
	<th>DesignationName</th>
</tr>
<c:forEach items="${designationlist}" var="designations">
   <tr>
    <td><c:out value="${designations.designationid}"/></td>
    <td><c:out value="${designations.designationname}"/></td>
    <td align="center">
    <a href="editDesignation.html?id=${designations.designationid}">Edit</a> |
     <a href="deleteDesignation.html?id=${designations.designationid}" title="delete ${designations.designationid} record" class="delete">Delete</a>
    </td>
   </tr>
</c:forEach>

</table>
</body>
</html>
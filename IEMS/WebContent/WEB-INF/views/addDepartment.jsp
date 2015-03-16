<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Department page</title>
	</head>
	<body>
		<h2 align="left">Departments are</h2>
		<form:form  method="POST" action="saveDepartment.html" commandName="departments" name="fm">
	   		<table bgcolor="skyblue" cellpadding="2">
	   		
	   	<tr>
           		<td><form:label path="departmentid">Department Id:</form:label></td>
           		<td><form:input path="departmentid" readonly="true"
						value="${emp.departmentid}" /></td>
       	</tr>
	   		
	   	<tr>
           		<td><form:label path="departmentname">Department Name:</form:label></td>
           		<td><form:input path="departmentname" required="required" value="${emp.departmentname}"/></td>
       </tr>
	    <tr>
			      <td colspan="2"><input type="submit" value="AddDepartments"/></td>
		      </tr>
			</table> 
		
		</form:form>
<table>
<tr>
	<th>DepartmentID</th>
	<th>DepartmentName</th>
</tr>
<c:forEach items="${departmentlist}" var="departments">
   <tr>
    <td><c:out value="${departments.departmentid}"/></td>
    <td><c:out value="${departments.departmentname}"/></td>
    <td align="center">
    <a href="editDepartment.html?id=${departments.departmentid}">Edit</a> |
     <a href="deleteDepartment.html?id=${departments.departmentid}" title="delete ${departments.departmentid} record" class="delete">Delete</a>
    </td>
   </tr>
</c:forEach>

</table>
</body>
</html>
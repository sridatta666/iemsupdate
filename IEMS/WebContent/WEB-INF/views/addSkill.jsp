<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>List Of Skills</title>
	</head>
	<body>
		<h2 align="left">Skills are adding below</h2>
		<form:form  method="POST" action="saveSkill.html" commandName="skills" name="fm">
	   		<table bgcolor="pink" cellpadding="2">
	   		
	   	<tr>
           		<td><form:label path="skillid">Skill Id:</form:label></td>
           		<td><form:input path="skillid" readonly="true"
						value="${emp.skillid}" /></td>
       	</tr>
	   		
	   	<tr>
           		<td><form:label path="skillname">Skill Name:</form:label></td>
           		<td><form:input path="skillname" required="required" value="${emp.skillname}"/></td>
       </tr>
	    <tr>
			      <td colspan="2"><input type="submit" value="AddSkills"/></td>
		      </tr>
			</table> 
		
		</form:form>
<table>
<tr>
	<th>SkillID</th>
	<th>SkillName</th>
</tr>
<c:forEach items="${skilllist}" var="skills">
   <tr>
    <td><c:out value="${skills.skillid}"/></td>
    <td><c:out value="${skills.skillname}"/></td>
    <td align="center">
    <a href="editSkill.html?id=${skills.skillid}">Edit</a> |
     <a href="deleteSkill.html?id=${skills.skillid}" title="delete ${skills.skillid} record" class="delete">Delete</a>
    </td>
   </tr>
</c:forEach>

</table>
</body>
</html>
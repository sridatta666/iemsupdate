<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Add Employees</title>
  
 </head>

<body>
  <h2>EmployeeDetails</h2>

  <form:form method="POST" commandName="employee" action="saveEmployee.html" name="fm">
  <center>
      <table>
       <tr>
           <td><form:label path="firstname">first name</form:label></td>
           <td><form:input path="firstname" required="required" value="${emp.firstname}"/></td>
       </tr>
       <tr>
           <td><form:label path="lastname">last name</form:label></td>
           <td><form:input path="lastname" required="required" value="${emp.lastname}"/></td>
       </tr>
       
 <tr>
        <td><form:label path="department">department</form:label></td>
				<td><form:select path="department">
				<c:forEach items="${deptlist}" var="dept">
					  <form:option value="${dept.departmentid }">${dept.departmentname}</form:option>
					  </c:forEach>
				       </form:select>
                                </td></tr>
                                <tr>
        <td><form:label path="designation">designation</form:label></td>
				<td><form:select path="designation">
				<c:forEach items="${desglist}" var="desg">
					  <form:option value="${desg.designationid }">${desg.designationname}</form:option>
					  </c:forEach>
				       </form:select>
                                </td></tr>
                                
          <tr>
         <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
       
   </table> 
  
   
   </center>
  </form:form>
<%-- <c:forEach items="${deptlist}" var="var">
<c:out value="${var.deptartment}" />
</c:forEach> --%>


<table border="2">
<tr><th>EID</th><th>FIRST NAME</th><th>LAST NAME</th><th>DEPARTMENT NAME</th><th>DESIGNATION NAME</th><th>USER ID</th></tr>
<c:forEach items="${emplist}" var="employee">
   <tr>
    <td><c:out value="${employee.eid}"/></td>
    <td><c:out value="${employee.firstname}"/></td>
    <td><c:out value="${employee.lastname}"/></td>
    <td><c:out value="${employee.department}"/></td>
    <td><c:out value="${employee.designation}"/></td>
    <td><c:out value="${employee.userid}"/></td>
    <td align="center"><a href="deleteEmployee.html?id=${employee.eid}" title="delete ${employee.eid} record" class="delete">Delete</a></td>
   </tr>
  </c:forEach>
  </table>

 </body>
</html>


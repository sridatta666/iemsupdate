<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit</title>

</head>
<body>
 
<div id=container align="justify">
<!-- ------------------------main edit form----------------------------- -->

<form action="editprofile" name="f1">
<div id=image align="left">
<img height="100px" width="100px" alt="" src="/home/sridattab/Downloads/unnamed.png" />  
</div>
<div id=content1>
<label>First Name</label><label>${pro1.firstname}</label><br>
<label>Last Name</label><label>${pro1.lastname}</label><br>
<label>Date Of Birth</label><input type="text" name=dobfld value='${emp1.dob}'><br>
<label>Passport</label><input type="text" name=passportfld value='${emp1.passport}'><br>
</div>
<div id=content2>
<label>Summary</label><textarea rows="5" cols="5" name=summaryfld >${emp1.summary}</textarea><br>
<br>
<br>
<input type="submit" id="as"/>
<br>
</form>
<!-- -----------------end of form--------------------- -->
<label>Skills</label><br>
 
<form action="skillselect">
<select name="skill" multiple>
<c:forEach items="${skillslist}" var="eachskill">
  <option value="${eachskill.skillid}">"${eachskill.skillname}"</option>
</c:forEach>
</select>
<input type="submit">
</form>



<label>Education</label>
<center>
<table border="2"cellpadding="2" cellspacing="2" align="center">
<tr align="center">
<th >Degree</th><th>University</th><th>Year</th>
</tr>

 <c:forEach items="${edu}" var="edu1">
 <tr align="center">

<c:forTokens items="${edu1.degree}" delims="," var="edu2">
<td><c:out value="${edu2}"></c:out></td>

</c:forTokens>
<td align="center"><a href="editedu?educolumnid=${edu1.id}">Edit</a> | <a href="deleteedu?educolumnid=${edu1.id}">Delete</a></td>

</tr>
</c:forEach>
</table><br>
<!-- -------Education form start----------------------------- -->
<form action="addedu" name="f2">
<input type="text" value="${degreestring}"  name="Degreefld">
<input type="text" value="${boardstring}"  name="Boardfld">
<input type="hidden" value="${educolumnidfld}" name="eduid">
<input type="text" value="${yearstring}"  name="Yearfld">
<input type="submit" id="submitedu" />
</form> 


<!-- -------Education form end----------------------------- -->


<label>Experience</label>
<table border="2"cellpadding="2" cellspacing="2" align="center">
<tr align="center">
<th>Organization</th><th>Designation</th><th>Start Date</th><th>End Date</th>
</tr>
<c:forEach items="${exp}" var="exp1">
 <tr align="center">

<c:forTokens items="${exp1.organization}" delims="," var="exp2">
<td><c:out value="${exp2}"></c:out></td>

</c:forTokens>
<td align="center"><a href="editexp?expcolumnid=${exp1.id}">Edit</a> | <a href="deleteexp?expcolumnid=${exp1.id}">Delete</a></td>

</tr>
</c:forEach>

</table>
</center><br>



<!-- -------Experience form start----------------------------- -->
<form action="addexp">
<input type="text" value="${orgstring}" name=orgfld>
<input type="text" value="${desgstring}" name=desgfld>
<input type="text" value="${startstring}" name=strtfld>
<input type="text" value="${endstring}" name=endfld>
<input type="hidden" value="${expcolumnidfld}" name=expid>
<input type="submit" id=submitexp/>
</form>
<!-- -------Experience form end----------------------------- -->

</div> 
 
</div>

</body>
</html>
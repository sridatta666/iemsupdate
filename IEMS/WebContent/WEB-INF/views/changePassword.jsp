<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript">
function validate()
{
	var pwd=document.f.pwd.value;
	var p=document.f.newpwd.value;
	var r=document.f.reenterpwd.value;
	if(pwd==p)
		{
		window.alert("old password and new password should not be same");
		}
	else if(p==r)
		{
			window.alert("success");
		}
	else
		{
			window.alert("Fail");
		}
}
</script>
</head>
<body>
<form name=f action="save.html">
Old Password:<input type="password" name="pwd"><br>
New password:<input type="password" name="newpwd"><br>
Retype Password:<input type="password" name="reenterpwd"><br>
<input type="submit" onclick="validate()">
</form>


</body>
</html>
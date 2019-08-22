<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addAdmin" method="post">
	<table align="center" border="1">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="username" id="username"></td>
			<td><span id="checkUsername"></span></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" name="password" id="password">
			<td><span id="checkPassword"></span></td>
		</tr>
		<tr>
			<td><input type="submit" value="提交" onclick="return check();"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
</form>
<script type="text/javascript">
	function check() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var flag1 = true;
		var flag2 = true;
		var re = /[a-zA-Z0-9]{6,16}/;
		if(username.trim().length == 0){
			document.getElementById("checkUsername").innerHTML = "用户名不能为空";
			flag1 = false
		}else{
			document.getElementById("checkUsername").innerHTML = "";
			flag1 = true;
		}
		if(password.trim().length == 0){
			document.getElementById("checkPassword").innerHTML = "密码不能为空";
			flag2 = false;
		}else if(re.test(password)){
			document.getElementById("checkPassword").innerHTML = "";
			flag2 = true;
		}else{
			document.getElementById("checkPassword").innerHTML = "密码必须由6到16个数字或字符串组成";
			flag2 = false;
		}
		if(flag1 == true&&flag2 == true) return true;
		else return false;
	}
</script>
</body>
</html>
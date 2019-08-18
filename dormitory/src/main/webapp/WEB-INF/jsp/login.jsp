<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录界面</title>
</head>
<body>
<form action="homepage" method="post">
	<table align="center">
	<caption align="top">用户登录</caption>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" id="username" onblur="checkUser(this.value);"></td>
			<td><span id="ckeckUserResult" style="color:red"></span></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password" id="password" onblur="checkPassword(this.value);"></td>
			<td><span id="ckeckPasswordResult" style="color:red"></span></td>
		</tr>
		<tr>
			<td><input type="submit" value="登录" onclick="return checkSubmit();"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	<script type="text/javascript">
		function checkUser(obj) {
			var username = obj;
			if(username.trim().length == 0){
				var checkUserNameResult = document.getElementById("ckeckUserResult");
				checkUserNameResult.innerHTML = "用户名不能为空";
				obj.focus();
			}else{
				checkUserNameResult.innerHTML = "";
			}
		}
		function checkPassword(obj) {
			var password = obj;
			if(password.trim().length == 0){
				var ckeckPasswordResult = document.getElementById("ckeckPasswordResult");
				ckeckPasswordResult.innerHTML = "密码名不能为空";
				obj.focus();
			}else{
				ckeckPasswordResult.innerHTML = "";
			}
		}
		function  checkSubmit() {
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			if(username.trim().length == 0 || password.trim().length == 0) return false;
			else return true;
		}
	</script>
</form>
</body>
<script type="text/javascript">

</script>
</html>

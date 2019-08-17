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
<form action="check" method="post">
	<table align="center" border="1" cellspacing='0'>
	<caption align="top">用户登录</caption>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="username" id="username"></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password" id="password"></td>
		</tr>
		<tr>
			<td><input type="submit" value="登录"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	<p id="error"></p>
</form>
</body>
<script type="text/javascript">

</script>
</html>

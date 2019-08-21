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
<h1>欢迎${username}</h1>
<div>
<table>
	<tr>
		<td><a href="building">宿舍楼栋管理</a></td>
	</tr>
	<tr>
		<td><a href="student/listStudent">学生信息</a></td>
	</tr>
	<tr>
		<td><a href="">教职工信息</a></td>
	</tr>
	<tr>
		<td><a href="">管理员信息</a></td>
	</tr>
</table>
<a href="student/test">增加学生信息</a>
</div>
</body>
</html>
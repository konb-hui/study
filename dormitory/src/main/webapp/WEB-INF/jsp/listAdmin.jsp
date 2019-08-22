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
<table align="center" border="1">
	<tr>
		<td>id</td>
		<td>用户名</td>
		<td>密码</td>
		<td>类型</td>
		<td>删除</td>
		<td>修改</td>
		<td><a href="addAdmin">增加普通管理员</a></td>
	</tr>
	<c:forEach items="${admins}" var="a" varStatus="st">
	<tr>
		<td>${a.id}</td>
		<td>${a.username}</td>
		<td>${a.password}</td>
		<c:if test="${a.type == 0}"><td>超级管理员</td></c:if>
		<c:if test="${a.type == 1}"><td>普通管理员</td></c:if>
		<td><a href="deleteAdmin?id=${a.id}">删除</a></td>
		<td><a href="editAdmin?id=${a.id}">修改</a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
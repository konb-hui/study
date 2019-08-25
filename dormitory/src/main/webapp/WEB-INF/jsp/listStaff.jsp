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
		<td>姓名</td>
		<td>性别</td>
		<td>年龄</td>
		<td>职位</td>
		<td>所住宿舍</td>
		<td>删除</td>
		<td>修改</td>
		<td><a href="addStaff">添加</a></td>
	</tr>
	<c:forEach items="${staffs}" var="s" varStatus="st">
	<tr>
		<td>${s.id}</td>
		<td>${s.name}</td>
		<td>${s.sex}</td>
		<td>${s.age}</td>
		<td>${s.position}</td>
		<c:if test="${s.doid==-1}"><td>无<a href="/dormitory/selectForStaff?id=${s.id}&sex=${s.sex}">添加</a></td></c:if>
		<c:if test="${s.doid>=0}"><td>${s.dormitory.dormitoryBuilding.name} ${s.dormitory.name}</c:if>
		<td><a href="deleteStaff?id=${s.id}">删除</a></td>
		<td><a href="editStaff?id=${s.id}">修改</a></td>
	</c:forEach>
</table>
<div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末  页</a>
   </div>
</body>
</html>
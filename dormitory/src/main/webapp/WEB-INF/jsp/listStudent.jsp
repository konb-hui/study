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
<form action="?flag=1" method="post">
	<table align="center">
		<tr>
			<td>请选择性别</td>
			<td><select name="sex">
				<option value="null">
				<option value="男">男</option>
				<option value="女">女</option>
				</select>
			</td>
			<td>请选择班级</td>
			<td><select name="className">
				<option value="null">
				<option value="一班">一班</option>
				<option value="二班">二班</option>
				<option value="三班">三班</option>
				<option value="四班">四班</option>
			</select>
			</td>
			<td>请选择年级</td>
			<td><select name="grade">
				<option value="null">
				<option value="高一">高一</option>
				<option value="高二">高二</option>
				<option value="高三">高三</option>
			</select></td>
			<td>请选择宿舍分配情况</td>
			<td><select name="doid">
				<option>
				<option value="0">已分配</option>
				<option value="-1">未分配</option>
			</select></td>
			<td>按名字搜索</td>
			<td><input name="name" type="text" id="name"></td>
			<td><input type="submit" value="搜索"></td>
		</tr>
	</table>
</form>
<table align="center" border="1">
	<tr>
		<td>学号</td>
		<td>姓名</td>
		<td>性别</td>
		<td>班级</td>
		<td>年级</td>
		<td>所在宿舍</td>
		<td>修改</td>
		<td>删除</td>
		<td><a href="/dormitory/addStudent">添加</a>
	</tr>
	<c:forEach items="${students}" var="s" varStatus="st">
	<tr>
		<td>${s.id}</td>
		<td>${s.name}</td>
		<td>${s.sex}</td>
		<td>${s.className}</td>
		<td>${s.grade}</td>
		<c:if test="${s.doid == -1}"><td>无</td></c:if>
		<c:if test="${s.doid > -1}"><td>${s.dormitory.dormitoryBuilding.name} ${s.dormitory.name}</c:if>
		<td><a href="editStudent?id=${s.id}">修改</a></td>
		<td><a href="deleteStudent?id=${s.id}">删除</a></td>
	</tr>
	</c:forEach>
</table>
<div style="text-align:center">
        <a href="?start=0&flag=2">首  页</a>
        <a href="?start=${page.start-page.count}&flag=2">上一页</a>
        <a href="?start=${page.start+page.count}&flag=2">下一页</a>
        <a href="?start=${page.last}&flag=2">末  页</a>
   </div>
</body>
</html>
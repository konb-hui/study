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
				<option value="男" ${map.sex eq "男"?'selected':''}>男</option>
				<option value="女" ${map.sex eq "女"?'selected':''}>女</option>
				</select>
			</td>
			<td>请选择班级</td>
			<td><select name="className">
				<option value="null">
				<option value="一班" ${map.className eq "一班"?'selected':''}>一班</option>
				<option value="二班" ${map.className eq "二班"?'selected':''}>二班</option>
				<option value="三班" ${map.className eq "三班"?'selected':''}>三班</option>
				<option value="四班" ${map.className eq "四班"?'selected':''}>四班</option>
			</select>
			</td>
			<td>请选择年级</td>
			<td><select name="grade">
				<option value="null">
				<option value="高一" ${map.grade eq "高一"?'selected':''}>高一</option>
				<option value="高二" ${map.grade eq "高二"?'selected':''}>高二</option>
				<option value="高三" ${map.grade eq "高三"?'selected':''}>高三</option>
				</select></td>
			<td>请选择宿舍分配情况</td>
			<td><select name="doid">
				<option>
				<option value="0" ${map.doid >= 0?'selected':''}>已分配</option>
				<option value="-1" ${map.doid == -1?'selected':''}>未分配</option>
			</select></td>
			<td>按名字搜索</td>
			<td><input name="name" type="text" id="name" value="${map.name}"></td>
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
		<td>修改宿舍</td>
		<td><a href="/dormitory/addStudent">添加</a>
	</tr>
	<c:forEach items="${students}" var="s" varStatus="st">
	<tr>
		<td>${s.id}</td>
		<td>${s.name}</td>
		<td>${s.sex}</td>
		<td>${s.className}</td>
		<td>${s.grade}</td>
		<c:if test="${s.doid == -1}"><td>无（<a href="/dormitory/selectForStudent?id=${s.id}&sex=${s.sex}">添加宿舍</a>）</td></c:if>
		<c:if test="${s.doid > -1}"><td>${s.dormitory.dormitoryBuilding.name} ${s.dormitory.name}</c:if>
		<td><a href="editStudent?id=${s.id}">修改</a></td>
		<td><a href="deleteStudent?id=${s.id}">删除</a></td>
		<c:if test="${s.doid == -1}"><td></td></c:if>
		<c:if test="${s.doid > -1}"><td><a href="/dormitory/selectForStudent?id=${s.id}&sex=${s.sex}&doid=${s.doid}">换宿舍</a></td></c:if>
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
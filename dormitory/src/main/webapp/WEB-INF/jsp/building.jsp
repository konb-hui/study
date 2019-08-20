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
	<table align="center" border="1" cellspacing="0">
		<tr>
			<td>楼栋id</td>
			<td>楼栋名字</td>
			<td>楼栋区数</td>
			<td>楼栋层数</td>
			<td>楼栋类型</td>
			<td>每层的房间数</td>
			<td>剩余可用房间数</td>
			<td>查看该楼栋的所有宿舍</td>
			<td>修改</td>
			<td>删除</td>
			<td><a href="addBuilding">添加</a></td>
		</tr>
		<c:forEach items="${dbs}" var="db" varStatus="st">
			<tr>
				<td>${db.id}</td>
				<td>${db.name}</td>
				<td>${db.areaNumber}</td>
				<td>${db.layerNumber}</td>
				<c:if test="${db.type == 0}"><td>男生宿舍</td></c:if>
				<c:if test="${db.type == 1}"><td>女生宿舍</td></c:if>
				<c:if test="${db.type == 2}"><td>教职工宿舍</td></c:if>
				<td>${db.layerRoomNumber}</td>
				<td>${db.surplusRoom}</td>
				<td><a href="listDormitory?id=${db.id}">查看</a></td>
				<td><a href="editBuilding?id=${db.id}">修改</a></td>
				<td><a href="deleteBuilding?id=${db.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="homepage">返回首页</a>
</body>
</html>
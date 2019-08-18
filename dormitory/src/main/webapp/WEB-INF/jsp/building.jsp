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
				<td>${db.type}</td>
				<td>${db.layerRoomNumber}</td>
				<td>${db.surplusRoom}</td>
				<td><a href="">修改</a></td>
				<td><a href="">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
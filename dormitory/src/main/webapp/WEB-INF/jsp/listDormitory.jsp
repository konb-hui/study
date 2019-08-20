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
		<td>宿舍名字</td>
		<td>剩余可住人数</td>
		<td>所属楼房</td>
		<td>点击查看已住用户</td>
	</tr>
	<c:forEach items="${ds}" var="d" varStatus="st">
	<tr>
		<td>${d.id}</td>
		<td>${d.name}</td>
		<td>${d.surplusBed}</td>
		<td>${d.dormitoryBuilding.name}</td>
		<td><a href="">查看</a></td>
	</tr>
	</c:forEach>
</table>	    
<div style="text-align:center">
        <a href="?start=0&id=${bid}">首  页</a>
        <a href="?start=${page.start-page.count}&id=${bid}">上一页</a>
        <a href="?start=${page.start+page.count}&id=${bid}">下一页</a>
        <a href="?start=${page.last}&id=${bid}">末  页</a>
   </div>
   <a href="building">返回building</a>
</body>
</html>
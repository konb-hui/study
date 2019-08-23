<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分配宿舍</title>
</head>
<body>
<c:if test="${student==null} and ${staff==null}">
	<h3>已经没有剩余的宿舍，去<a href="">添加</a></h3>
</c:if>
<c:if test="${student!=null}">
<form action="selectDormitory?sid=${student.id}" method="post">
	<table align="center">
		<tr>
			<td>请选择楼栋</td>
			<td><select name="bid">
			<c:forEach items="${dbs}" var="db" varStatus="st">
				<option value="${db.id}">${db.name}</option>
			</c:forEach>
			</select></td>
			<td><input type="submit" value="确定"></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${ds!=null}">
	<table align="center" border="1">
		<tr>
			<td>名称</td>
			<td>剩余可住人数</td>
			<td colspan="4">已住</td>
		</tr>
		<c:forEach items="${ds}" var="d" varStatus="st">
			<td>${d.name}</td>
			<td>${d.surplusBed}</td>
			<c:forEach items="${d.students}" var="s" varStatus="st">
			<td>${s.grade}${s.className}${s.name}</td>
			</c:forEach>
			<td><a href="">增加</a></td>
		</c:forEach>
	</table>
</c:if>
</body>
</html>

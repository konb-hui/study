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
<form action="selectDormitory?sid=${student.id}&flag=0" method="post">
	<table align="center">
		<tr>
			<td>请选择楼栋</td>
			<td><select name="bid" id="bid" value="${bid}">
			<c:forEach items="${dbs}" var="db" varStatus="st">
				<option value="${db.id}">${db.name}</option>
			</c:forEach>
			</select></td>
			<td><input type="submit" value="确定"></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${staff!=null}">
<form action="selectDormitory?sid=${staff.id}&flag=1" method="post">
	<table align="center">
		<tr>
			<td>请选择楼栋</td>
			<td><select name="bid" id="bid" value="${bid}">
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
		<tr>
			<td>${d.name}</td>
			<td>${d.surplusBed}</td>
			<c:if test="">
			
			</c:if>
		<c:if test="${d.students!=null}">
			<c:forEach items="${d.students}" var="s" varStatus="st">
			<td>${s.grade}${s.className}${s.name}</td>
			</c:forEach>
			<td><a href="student/addDormitoryForStudent?id=${sid}&doid=${d.id}">增加</a></td>
		</c:if>
			<c:if test="${d.staffs!=null}">
			<c:forEach items="${d.staffs}" var="s" varStatus="st">
			<td>${s.age}${s.position}${s.name}</td>
			</c:forEach>
			<td><a href="staff/addDormitoryForStaff?id=${sid}&doid=${d.id}">增加</a></td>
		</c:if>
		</tr>
		</c:forEach>
	</table>
	<div style="text-align:center">
        <a href="selectDormitory?start=0&sid=${sid}&bid=${bid}">首  页</a>
        <a href="selectDormitory?start=${page.start-page.count}&sid=${sid}&bid=${bid}">上一页</a>
        <a href="selectDormitory?start=${page.start+page.count}&sid=${sid}&bid=${bid}">下一页</a>
        <a href="selectDormitory?start=${page.last}&sid=${sid}&bid=${bid}">末  页</a>
   </div>
</c:if>
</body>
</html>

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
<c:if test="${student!=null}">
<form action="changeDormitory?sid=${student.id}&flag=0" method="post">
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
<form action="changeDormitory?sid=${staff.id}&flag=1" method="post">
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
			<td colspan="4">已住(点击进行交换)</td>
		</tr>
		<c:forEach items="${ds}" var="d" varStatus="st">
		<tr>
			<td>${d.name}</td>
			<td>${d.surplusBed}</td>
			<c:if test="">
			
			</c:if>
		<c:if test="${d.students!=null}">
			<c:forEach items="${d.students}" var="s" varStatus="st">
			<td><a href="student/changeDormitoryForStudent?id=${sid}&sid=${s.id}">${s.grade}${s.className}${s.name}</a></td>
			</c:forEach>
			<c:if test="${d.surplusBed==0}"><td></td></c:if>
			<c:if test="${d.surplusBed!=0}">
				<td><a href="student/updateDormitoryForStudent?id=${sid}&doid=${d.id}">增加</a></td>
			</c:if>
		</c:if>
			<c:if test="${d.staffs!=null}">
			<c:forEach items="${d.staffs}" var="s" varStatus="st">
			<td><a href="staff/changeDormitoryForStaff?id=${sid}&sid=${s.id}"">${s.age}${s.position}${s.name}</a></td>
			</c:forEach>
			<c:if test="${d.surplusBed==0}"><td></td></c:if>
			<c:if test="${d.surplusBed!=0}">
				<td><a href="staff/updateDormitoryForStaff?id=${sid}&doid=${d.id}">增加</a></td>
			</c:if>
		</c:if>
		</tr>
		</c:forEach>
	</table>
	<div style="text-align:center">
        <a href="changeDormitory?start=0&sid=${sid}&bid=${bid}">首  页</a>
        <a href="changeDormitory?start=${page.start-page.count}&sid=${sid}&bid=${bid}">上一页</a>
        <a href="changeDormitory?start=${page.start+page.count}&sid=${sid}&bid=${bid}">下一页</a>
        <a href="changeDormitory?start=${page.last}&sid=${sid}&bid=${bid}">末  页</a>
   </div>
</c:if>
</body>
</html>
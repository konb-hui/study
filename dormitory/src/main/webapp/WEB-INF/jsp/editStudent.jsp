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
<form action="updateStudent" method="post">
	<table align="center" border="1">
		<tr>
			<td>姓名</td>
			<td><input name="name" value="${student.name}" id="name"></td>
			<td><span id="checkName"></span></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><select name="sex">
			<option value="男" ${student.sex eq "男"?'selected':''}>男</option>
			<option value="女" ${student.sex eq "女"?'selected':''}>女</option>
			</select></td>
		</tr>
		<tr>
			<td>班级</td>
			<td><select name="className">
			<option value="一班" ${student.className eq "一班"?'selected':''}>一班</option>
			<option value="二班" ${student.className eq "二班"?'selected':''}>二班</option>
			<option value="三班" ${student.className eq "三班"?'selected':''}>三班</option>
			<option value="四班" ${student.className eq "四班"?'selected':''}>四班</option>
			</select></td>
		</tr>
		<tr>
			<td>年级</td>
			<td><select name="grade">
			<option value="高一" ${student.grade eq "高一"?'selected':''}>高一</option>
			<option value="高二" ${student.grade eq "高二"?'selected':''}>高二</option>
			<option value="高三" ${student.grade eq "高三"?'selected':''}>高三</option>
			</select></td>
		</tr>
		<tr>
			<td><input type="hidden" name="id" value="${student.id}">
			<input type="hidden" name="doid" value="${student.doid}">
			<input type="submit" value="提交" onclick="return check();"></td>
			<td><input type="reset" value="重置"></td>
	</table>
</form>
<script type="text/javascript">
	function check() {
		var name = document.getElementById("name").value;
		if(name.trim().length == 0){
			document.getElementById("checkName").innerHTML = "名字不能为空";
			return false;
		}
		else {
			document.getElementById("checkName").innerHTML = "";
			return true
		}
	}
</script>
</body>
</html>
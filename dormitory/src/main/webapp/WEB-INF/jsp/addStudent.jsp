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
<form action="student/addStudent">
	<table align="center" border="1">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><select name="sex">
				<option value="男">男</option>
				<option value="女">女</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>班级</td>
			<td><select name="className">
				<option value="一班">一班</option>
				<option value="二班">二班</option>
				<option value="三班">三班</option>
				<option value="四班">四班</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>年级</td>
			<td><select name="grade">
				<option value="高一">高一</option>
				<option value="高二">高二</option>
			</select></td>
		</tr>
		<tr>
			<td><input type="submit" value="提交"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
</form>
</body>
</html>
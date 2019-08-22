<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add" method="post">
	<table align="center" border="1">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name" id="name"></td>
			<td><span id="checkName"></span></td>
		</tr>
		<tr>
			<td>性别</td>
			<td><select name="sex">
				<option value="男">男</option>
				<option value="女">女</option>
			</select></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input name="age" type="text" id="age"></td>
			<td><span id="checkAge"></span></td>
		</tr>
		<tr>
			<td>职位</td>
			<td><input type="text" name="position" id="position"></td>
			<td><span id="checkPosition"></span></td>
		</tr>
		<tr>
			<td><input value="提交" type="submit" onclick="return check();"></td>
			<td><input value="重置" type="reset"></td>
		</tr>
	</table>
</form>
<script type="text/javascript">
	function checkName() {
		var name = document.getElementById("name").value;
		var flag = true;
		if(name.trim().length == 0){ 
			document.getElementById("checkName").innerHTML = "输入的名字不能为空";
			flag = false;
		}else{
			document.getElementById("checkName").innerHTML = "";
		}
		return flag;
	}
	function checkAge() {
		var age = document.getElementById("age").value;
		var flag = true;
		if(age<18||age>=60){
			document.getElementById("checkAge").innerHTML = "输入的年龄不正确";
			flag = false;
		}else if(age>=18&&age<60){
			document.getElementById("checkAge").innerHTML = "";
			flag = true;
		}else{
			document.getElementById("checkName").innerHTML = "输入的年龄不合法";
			flag = false;
		}
		return flag;
	}
	function checkPosition() {
		var position = document.getElementById("position").value;
		var flag = true;
		if(position.trim().length == 0){
			document.getElementById("checkPosition").innerHTML = "输入的职位不能为空";
			flag = false;
		}else{
			document.getElementById("checkPosition").innerHTML = "";
		}
		return flag;
	}
	function check() {
		var flag1 = checkName();
		var flag2 = checkAge();
		var flag3 = checkPosition();
		if(flag1==true&&flag2==true&&flag3==true) return true;
		else return false;
	}
</script>
</body>
</html>
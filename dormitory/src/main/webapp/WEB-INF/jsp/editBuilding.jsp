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
<form action="updateBuilding" method="post">
	<table align="center" border="1" cellspacing="0">
		<tr>
			<td>楼栋名字</td>
			<td><input type="text" name="name" id="name" value="${db.name}"></td>
			<td><span id="checkName" style="color:red"></span></td>
		</tr>
		<tr>
			<td>楼栋类型</td>
			<td><select name="type" id="type">
				<option value="0" ${db.type == 0?'selected':''}>男生宿舍</option>
				<option value="1" ${db.type == 1?'selected':''}>女生宿舍</option>
				<option value="2" ${db.type == 2?'selected':''}>教职工宿舍</option>
			</select></td>		
		</tr>
		<tr>
			<td><input type="reset" value="重置"></td>
			<td><input type="submit" value="提交" onclick="return check();"></td>
			<td><input type="hidden" name="surplusRoom" id="surplusRoom" value="${db.surplusRoom}">
				<input type="hidden" name="areaNumber" value="${db.areaNumber}"> 
				<input type="hidden" name="layerNumber" value="${db.layerNumber}">
				<input type="hidden" name="layerRoomNumber" value="${db.layerRoomNumber}">
				<input type="hidden" name="id" value="${db.id}">
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		function check() {
			var flag = true;
			var name = document.getElementById("name").value;
			if(name.trim().length == 0){
				document.getElementById("checkName").innerHTML = "名字不能为空";
				flag = false;
			}else{
				document.getElementById("checkName").innerHTML = "";
				flag = true;
			}
			return flag;
		}
	</script>
</form>
</body>
</html>
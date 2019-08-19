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
<form action="add" method="post">
	<table align="center" border="1" cellspacing="0">
		<tr>
			<td>楼栋名字</td>
			<td><input type="text" name="name" id="name"></td>
			<td><span id="checkName" style="color:red"></span></td>
		</tr>
		<tr>
			<td>楼栋区数</td>
			<td><select name="areaNumber" id="areaNumber">
				<option value="1">1</option>
				<option value="2">2</option>
			</select></td>
		</tr>
		<tr>
			<td>楼栋层数</td>
			<td><input type="text" name="layerNumber" id="layerNumber"></td>
			<td><span id="checkLayerNumber" style="color:red"></span></td>
		</tr>
		<tr>
			<td>楼栋类型</td>
			<td><select name="type" id="type">
				<option value="0">男生宿舍</option>
				<option value="1">女生宿舍</option>
				<option value="2">教职工宿舍</option>
			</select></td>
			
		</tr>
		<tr>
			<td>每层的房间数</td>
			<td><input type="text" name="layerRoomNumber" id="layerRoomNumber"></td>
			<td><span id="checkLayerRoomNumber" style="color:red"></span></td>
		</tr>
		<tr>
			<td><input type="reset" value="重置"></td>
			<td><input type="submit" value="提交（自动生成房间信息）" onclick="return check();"></td>
			<td><input type="hidden" name="surplusRoom" id="surplusRoom"></td>
		</tr>
	</table>
	<script type="text/javascript">
		function check() {
			var flag1 = true;
			var flag2 = true;
			var flag3 = true;
			var flag = true;
			var name = document.getElementById("name").value;
			var layerNumber = document.getElementById("layerNumber").value;
			var layerRoomNumber = document.getElementById("layerRoomNumber").value;
			if(name.trim().length == 0){
				document.getElementById("checkName").innerHTML = "名字不能为空";
				flag1 = false;
			}else{
				document.getElementById("checkName").innerHTML = "";
				flag1 = true;
			}
			if(layerNumber.trim().length == 0){
				document.getElementById("checkLayerNumber").innerHTML = "层数不能为空";
				flag2 = false;
			}
			else if(isNaN(layerNumber) || layerNumber<0 || layerNumber>10){
				document.getElementById("checkLayerNumber").innerHTML = "请输入正确的层数";
				flag2 = false;
			}else{
				document.getElementById("checkLayerNumber").innerHTML = "";
				flag2 = true;
			}
			if(layerRoomNumber.trim().length == 0){
				document.getElementById("checkLayerRoomNumber").innerHTML = "每层的房间数不能为空";
				flag3 = false;
			}
			else if(isNaN(layerRoomNumber) || layerRoomNumber<0 || layerRoomNumber>100){
				document.getElementById("checkLayerRoomNumber").innerHTML = "请输入正确的房间数";
				flag3 = false;
			}else{
				document.getElementById("checkLayerRoomNumber").innerHTML = "";
				flag3 = true;
			}
			if(flag1 == true && flag2 == true && flag3 == true) {
				surplus();
				flag = true;
			}
			else flag = false;
			return flag;
		}
		function surplus() {
			var areaNumber = document.getElementById("areaNumber").value;
			var layerNumber = document.getElementById("layerNumber").value;
			var layerRoomNumber = document.getElementById("layerRoomNumber").value;
			var n = areaNumber * layerNumber * layerRoomNumber;
			document.getElementById("surplusRoom").value = n;
		}
	</script>
</form>
</body>
</html>
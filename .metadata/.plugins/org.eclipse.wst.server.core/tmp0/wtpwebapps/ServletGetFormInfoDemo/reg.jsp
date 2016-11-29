<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Registration</title>
</head>
<body>
<h1>用户注册</h1>
<hr>
<form name="regForm" action="Res.do" method="post">
		<table border="0" width="800" cellpadding="0" cellspacing="0" >
			<tr>
				<td class="label">用户名：</td>
				<td class="controler"><input type="text" name ="username"></td>
			</tr>
			<tr>
				<td class="label">性别：</td>
				<td class="controler"><input type="radio" name ="gender" checked="checked" value="Male">男<input type="radio" name ="gender"  value="Female">女</td>
			</tr>
			<tr>
				<td class="label">出生日期：</td>
				<td class="controler"><input type="text" name ="birthday" id="control_date"
				size="10" maxlength="10" >格式：1994-02-17</td>
			</tr>
			<tr>
				<td class="label">爱好：</td>
				<td class="controler">
				<input type="checkbox" name ="favourite" value="music">音乐
				<input type="checkbox" name ="favourite" value="moive">电影
				<input type="checkbox" name ="favourite" value="Internet">上网
				</td>
			</tr>
			<tr>
				<td class="label">接受协议：</td>
				<td class="controler">
				<input type="checkbox" name ="isAccept" value="true">接受霸王条款！
				</td>
			</tr>
		</table>
		<center>
		<input type="SUBMIT">
		</center>
</form>
</body>
</html>
<%@ page language="java" import="java.util.*,java.text.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>UserInfo</title>
</head>
<body>
<h1>用户信息</h1>
<hr>
<jsp:useBean id="regUser" class="entity.Users" scope = "session"></jsp:useBean>
<center>
	<table width="600" cellpadding ="0" cellspacing="0" border="1">
		<tr>
			<td class="title">用户名</td>
			<td class="content">&nbsp;<jsp:getProperty name="regUser" property="username"/></td>
		</tr>
		<tr>
			<td class="title">性别</td>
			<td class="content">&nbsp;<jsp:getProperty name="regUser" property="gender"/></td>
		</tr>
		<tr>
			<td class="title">出生日期</td>
			<td class="content">&nbsp;
			<%
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				String dt = sdf.format(regUser.getBirthday());
			%>
			<%=dt %>
			</td>
		</tr>
		<tr>
			<td class="title">爱好</td>
			<td class="content">&nbsp;
			<%
				String[] favourites = regUser.getFavourites();
				for(String f:favourites)
				{
			%>
				<%=f %>&nbsp;&nbsp;
			<%
				}
			%>
			</td>
		</tr>
		<tr>
			<td class="title">是否接受协议</td>
			<td class="content">&nbsp;<jsp:getProperty name="regUser" property="flag"/></td>
		</tr>
	</table>
</center>
</body>
</html>
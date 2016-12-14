<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
The friends who share your hobby of

<%--表达式--%>
<%= request.getAttribute("hobby")
%>
are:<br>

<%
ArrayList al = (ArrayList)request.getAttribute("names");
%>
<%
Iterator it = al.iterator();
while(it.hasNext())
{%>
<%= it.next()%>
<br>
<%}%>
</body>
</html>
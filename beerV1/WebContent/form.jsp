<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="formTags" uri="http://example.com/tag/forms" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align = "center">Beer Selection Page</h1>
<form action="SelectBeer.do" method ="POST">
Select beer characteristics<p>
Color:
<formTags:select name='color' size='1' optionsList='${applicationScope.colorList}' /> 
<br></br>
<center>
<input type="SUBMIT">
</center>

</form>
</body>
</html>
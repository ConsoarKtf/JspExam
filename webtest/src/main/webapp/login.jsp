<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<form action="<%=request.getContextPath()%>/login01" method="post">
username:<input type="text" name="uname"/>
<br/>
<input type="submit" value="登录"/>
<input type="reset" value="重置"/>
</form>
</body>
</html>
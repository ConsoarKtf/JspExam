<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加影片</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<form action="<%=request.getContextPath()%>/add01" method="post">
title:<input type="text" name="utitle"/><br/>
description:<input type="text" name="udescription"/><br/>
language:<input type="checkbox" name="ulanguage" value="English"/>English
<input type="checkbox" name="ulanguage" value="Italian"/>Italian
<input type="checkbox" name="ulanguage" value="English"/>Japanese
<input type="checkbox" name="ulanguage" value="Mandarin"/>Mandarin
<input type="checkbox" name="ulanguage" value="French"/>French
<input type="checkbox" name="ulanguage" value="German"/>German
<br/>
<input type="submit" value="确定"/>
<input type="reset" value="重置"/>
</form>
</body>
</html>
<%@page import="com.green.entity.Lesson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/resources/css/main.css"
	rel="stylesheet" type="text/css">
<title>Lesson Management</title>
</head>
<body>
<%
List<Lesson> lessonList = (List<Lesson>) request.getAttribute("lesson_list");
%>
</body>
</html>
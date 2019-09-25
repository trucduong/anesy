<%@page import="com.green.entity.CourseCategory"%>
<%@page import="com.green.model.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- import css files --%>
<jsp:include page="../../component/common-css.jsp"></jsp:include>

</head>
<body>
<jsp:include page="../../component/header.jsp"></jsp:include>

<div class="container page">
<div class="row">
<div class="col-md-3"><jsp:include page="../../component/left.jsp"></jsp:include></div>
<div class="col-md-8">

<%
	
%>

<h1 class="page-title">Course Category</h1>

<div class="row justify-content-center">
	<div class="col-md-12">
		<form >
		  <div class="form-group">
		    <label for="catName">Category Name</label>
		    <input type="text" class="form-control" id="catName" placeholder="Enter course category name">
		  </div>
		  <div class="form-group">
		    <label for="catDescription">Password</label>
		    <input type="password" class="form-control" id="catDescription" placeholder="Description">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		  <button type="button" onclick="window.href=<%=request.getContextPath() %>/admin/course-category" class="btn btn-default">Cancel</button>
		</form>
	</div>
</div>

</div>
<div class="col-md-1"><jsp:include page="../../component/right.jsp"></jsp:include></div>
</div>
</div>

<jsp:include page="../../component/footer.jsp"></jsp:include>

<%-- import js files --%>
<jsp:include page="../../component/common-js.jsp"></jsp:include>
</body>
</html>
<%@page import="com.green.entity.Subjects"%>
<%@page import="com.green.model.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subjects</title>

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

<h1 class="page-title">Subjects</h1>

<div class="row">
	
	<form>
  <div class="form-group">
    <label for="Subjectname">Subject name</label>
    <input type="text" class="form-control" id="Subjectname" aria-describedby="Subject" placeholder="Enter subject name" size="80">
    <small id="Subject" class="form-text text-muted">Tên môn học phải hợp lệ</small>
  </div>
  <div class="form-group">
    <label for="decripsion">Decription</label>
    <input type="text" class="form-control" id="decripsion" placeholder="Description" size="80">
  </div>
  <div class="form-group">
    <label for="author">Author</label>
    <input type="text" class="form-control" id="author" placeholder="author" size="80">
  </div>
  
  <div class="form-group">
    <label for="tag">Tag</label>
    <input type="text" data-role="tagsinput" />
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
	
	
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
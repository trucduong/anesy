<%@page import="com.green.entity.Lesson"%>
<%@page import="com.green.entity.CourseCategory"%>
<%@page import="com.green.model.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lesson</title>

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
	Page<Lesson> pageData = (Page<Lesson>) request.getAttribute("_pageData");
	String filter = request.getParameter("filter");
	if (filter == null) {
		filter = "";
	}
%>

<h1 class="page-title">Lesson List</h1>

<div class="row">
	<div class="input-group mb-1">
		<form class="action-form" method="get" style="display: flex !important;">
			<input name="page" type="hidden" value="1">
			<input name="filter" type="text" class="form-control" placeholder="..." value="<%=filter %>">
			<div class="input-group-append">
				<button class="btn btn-success" type="submit" >Search</button>
			</div>
		</form>
		<div class="input-group-append">
			<form class="action-form" action="lesson/create" method="get" style="display: flex !important;">
				<button type="submit" class="btn btn-primary">Tạo mới</button>
			</form>
		</div>
	</div>
</div>


<div class="row">
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Tên</th>
	      <th scope="col">Mô tả</th>
	       <th scope="col">Môn học</th>
	        <th scope="col">Mục lục</th>
	        <th scope="col">Ngày tạo</th>
	      <th scope="col">Tùy chọn</th>
	    </tr>
	  </thead>
	  <tbody>
<%
	for(Lesson lesson : pageData.getList()) {
%>
	    <tr>
	      <th scope="row"><%=lesson.getId() %></th>
	      <td><%=lesson.getName() %></td>
	      <td><%=lesson.getDescription() %></td>
	      <td><%=lesson.getSubjects().getName() %></td>
	      <td><%=lesson.getSeq() %></td>
	      <td><%=lesson.getCreatedAt() %></td>
	      <td>
	      	<form class="action-form" action="lesson/<%=lesson.getId() %>" method="get">
	      		<button type="submit">Update</button>
	      	</form>
	      	<form class="action-form" action="lesson/delete/<%=lesson.getId() %>" method="post">
	      		<button type="submit">Delete</button>
	      	</form>
	      </td>
	    </tr>
<% } %>
	  </tbody>
	</table>
</div>


<div class="row">
	<div class="col-md-12">
		<nav>
			<ul class="pagination justify-content-center">
				<li class="page-item <%=pageData.getCurrent()<=1?"disabled": "" %>">
					<form class="action-form" id="pagingFormPrevious" method="get">
						<input name="filter" type="hidden" type="text" value="<%=filter %>">
						<input name="page" type="hidden" type="text" value="<%=(pageData.getCurrent() - 1) %>">
						<a class="page-link" href="#" onclick="javascript:$('#pagingFormPrevious').submit();">&laquo;</a>
					</form>
				</li>
<%
	for (int i = 1; i <= pageData.getTotal(); i++) {
%>
				<li class="page-item <%=i==pageData.getCurrent()?"active": "" %>">
					<form class="action-form" id="pagingForm<%=i %>" method="get">
						<input name="filter" type="hidden" type="text" value="<%=filter %>">
						<input name="page" type="hidden" type="text" value="<%=(i) %>">
						<a class="page-link" href="#" onclick="javascript:$('#pagingForm<%=i %>').submit();"><%=i %></a>
					</form>
				</li>
<% } %>
				<li class="page-item <%=pageData.getCurrent()>=pageData.getTotal()?"disabled": "" %>">
					<form class="action-form" id="pagingFormNext" method="get">
						<input name="filter" type="hidden" type="text" value="<%=filter %>">
						<input name="page" type="hidden" type="text" value="<%=(pageData.getCurrent() + 1) %>">
						<a class="page-link" href="#" onclick="javascript:$('#pagingFormNext').submit();">&raquo;</a>
					</form>
				</li>
			</ul>
		</nav>
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

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.green.entity.CourseSubjects"%>
<%@page import="com.green.entity.Course"%>
<%@page import="com.green.dao.CouseDao"%>
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
	Page<Subjects> pageData = (Page<Subjects>) request.getAttribute("_pageData");
	String filter = request.getParameter("filter");
	if (filter == null) {
		filter = "";
	}
%>
<%
	Map<Integer, List<Course>> courseSubjectsMap = (Map<Integer, List<Course>>) request.getAttribute("listCourseSubjects");
%> 

<h1 class="page-title">Subjects List</h1>

<div class="row">
	<div class="input-group mb-1">
		<form method="get" style="display: flex !important;">
			<input name="page" type="hidden" value="1">
			<input name="filter" type="text" class="form-control" placeholder="..." value="<%=filter %>">
			<div class="input-group-append">
				<button class="btn btn-success" type="submit" >Search</button>
			</div>
		</form>
		<div class="input-group-append">
			<form action="subjects/create" method="get" style="display: flex !important;">
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
	       <th scope="col">Khóa học</th>
	      <th scope="col">Ngày tạo</th>
	      <th scope="col">Tùy chọn</th>
	    </tr>
	  </thead>
	  <tbody>
<%
	for(Subjects subjects : pageData.getList()) {
%>
	    <tr>
	      <th scope="row"><%=subjects.getId() %></th>
	      <td><%=subjects.getName() %></td>
	      <td><%=subjects.getDescription() %></td>
	      <td>
	     <%
	     for(Course course:courseSubjectsMap.get(subjects.getId())) {
	     %>
	     <p><%=course.getId() %>:<%=course.getName() %></p>
	     <% } %>
	      </td>
	      <td><%=subjects.getCreatedAt() %></td>
	      <td>
	      	<form action="subjects/<%=subjects.getId() %>" method="get">
	      		<button class="btn btn-default btn-sm" type="submit"><i class="material-icons">edit</i></button>
	      	</form>
	      	<form action="subjects/delete/<%=subjects.getId() %>" method="post">
	      		<button class="btn btn-default btn-sm" type="submit"><i class="material-icons">delete</i></button>
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
					<form id="pagingFormPrevious" method="get">
						<input name="filter" type="hidden" type="text" value="<%=filter %>">
						<input name="page" type="hidden" type="text" value="<%=(pageData.getCurrent() - 1) %>">
						<a class="page-link" href="#" onclick="javascript:$('#pagingFormPrevious').submit();">&laquo;</a>
					</form>
				</li>
<%
	for (int i = 1; i <= pageData.getTotal(); i++) {
%>
				<li class="page-item <%=i==pageData.getCurrent()?"active": "" %>">
					<form id="pagingForm<%=i %>" method="get">
						<input name="filter" type="hidden" type="text" value="<%=filter %>">
						<input name="page" type="hidden" type="text" value="<%=(i) %>">
						<a class="page-link" href="#" onclick="javascript:$('#pagingForm<%=i %>').submit();"><%=i %></a>
					</form>
				</li>
<% } %>
				<li class="page-item <%=pageData.getCurrent()>=pageData.getTotal()?"disabled": "" %>">
					<form id="pagingFormNext" method="get">
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
</div>
</div>

<jsp:include page="../../component/footer.jsp"></jsp:include>
 
<%-- import js files --%>
<jsp:include page="../../component/common-js.jsp"></jsp:include>
</body>
</html>
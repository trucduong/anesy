<%@page import="com.green.entity.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.green.entity.CourseCategory"%>
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
	<%
	List<CourseCategory> categorylist =  (List<CourseCategory>)request.getAttribute("_categories"); 
	List<Course> courselist = (List<Course>)request.getAttribute("_courses");
	%>
	
	<jsp:include page="../../component/header.jsp"></jsp:include>

	<div class="container page">
		<div style="height: 10px"></div>
		<div class="row">
			<div class="col-md-8 offset-md-2">
			<form method="get">
				<input type="hidden" name="catId" value="<%=request.getParameter("catId")%>">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<button class="btn btn-outline-secondary dropdown-toggle"
							type="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Dropdown</button>
						<div class="dropdown-menu">
							<%for(CourseCategory category: categorylist ){%>
								<a class="dropdown-item" href="#"><%=category.getName() %></a>
							<%} %>
						</div>
					</div>
					<input name="filter" placeholder="Tìm kiếm khóa học" type="text" value="<%=request.getParameter("filter") %>" class="form-control">
					<div class="input-group-prepend">
						<button class="btn btn-outline-primary" type="submit" >Search</button>
					</div>
				</div>
			</form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h4>Tìm được 3 kết quả</h4>
			</div>
		</div>
		
		<%for(Course course:courselist) {%>
		<a href="<%=request.getContextPath()%>/course/<%=course.getId()%>">
		<div class="row">
			<div class="card mb-3">
				<div class="row no-gutters">
					<div class="col-md-2">
						<img
							src="<%=request.getContextPath()%>/resources/image/avatar-comment-image/hinh2.jpg"
							class="card-img" alt="" >
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title"><%=course.getName() %></h5>
							<p class="card-text">
								<small class="text-muted"></small>
							</p>
							<p class="card-text"><%=course.getShortdesc() %></p>
							<p class="card-text"><%=course.getAuthor().getFullName() %></p>
						</div>
					</div>
					<div class="col-md-2">
						<div class="giatien">
							<b><%=course.getPrice()%>VNĐ</b>
						</div>
						<div class="giatien">
						<span class="oi oi-star"><%=5%></span>
						</div>
					</div>
				</div>
			</div>
		</div>
		</a>
		<%} %>



	</div>

	<jsp:include page="../../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../../component/common-js.jsp"></jsp:include>
</body>
</html>
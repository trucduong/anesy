<%@page import="com.green.entity.Profile"%>
<%@page import="com.green.entity.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="../component/header.jsp"></jsp:include>

	<%
		List<Course> courseList = (List<Course>) request.getAttribute("_courselist");
		Profile profile = (Profile) request.getAttribute("_teacherprofile");
	%>
	<div class="full-width-name"
		style="height: 150px; background-color: #ffe494; margin-bottom: 50px;">
		<div class="teacher-name" style="padding: 30px 150px;">
			<b><h2><%=profile.getFullName() %></h2></b>
			<h5>Java Python Android and C# Expert Developer - 532K+ students</h5>
		</div>
	</div>
	<div class="container page">
		<div class="row teacher-decription">
			<div class="col-md-2" style="margin-left: 50px; min-height: 300px;">
				<div style="margin-left: 20px;">
					<img class="author-avatar" alt=""
						src="<%=request.getContextPath()%>/image/profile/<%=profile.getAvatar() %>"
						width="120" height="120">
				</div>
			</div>
			<div class="col-md-6" style="margin-left: 50px;">
				<div class="course-author-decription" style="margin-top: 10px;">
					<p>You’ve just stumbled upon the most complete, in-depth Java
						programming course online. With over 260,000 students enrolled and
						tens of thousands of 5 star reviews to date, these comprehensive
						java tutorials cover everything you’ll ever need.</p>
				</div>
				<ul class="nav justify-content-center" style="padding-top: 50px;">
					<li class="nav-item thong-so">
						<div class="medium">Khóa học</div>
						<div class="so"><%=courseList.size() %></div>
					</li>
					<li class="nav-item thong-so">
						<div class="medium">Like</div>
						<div class="so">130,175</div>
					</li>
					<li class="nav-item thong-so">
						<div class="medium">Unlike</div>
						<div class="so">130,175</div>
					</li>
				</ul>
			</div>
		</div>

		<div class="row teacher-course">
			<div class="title">Các khóa học của <%=profile.getFullName() %></div>
			<div class="col-md-12">
				<div class="tab-content" id="nav-tabContent"
					style="margin-top: 10px;">

						
						<div class="card-columns">
						<%for(Course course : courseList){ %>
						<a href="<%=request.getContextPath()%>/course/<%=course.getId()%>">
							<div class="card" style="min-height: 280px;">
								<img src="" class="card-img-top"
									alt="Java Programming Masterclass for Software Developers">
								<div class="card-body">
									<h5 class="card-title"><%=course.getName() %></h5>
									<p class="card-text"><%=course.getShortdesc() %></p>
									<p class="card-text text-right">
										<b><%=course.getPrice() %> VND</b>
									</p>
								</div>
							</div>
						</a>
							<%} %>
						</div>
					


				</div>
			</div>

		</div>
	</div>

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
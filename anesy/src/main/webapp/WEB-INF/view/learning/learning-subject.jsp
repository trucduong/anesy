<%@page import="com.green.entity.Lesson"%>
<%@page import="com.green.entity.CourseSubjects"%>
<%@page import="com.green.entity.CourseRegistration"%>
<%@page import="com.green.entity.CourseComment"%>
<%@page import="java.util.List"%>
<%@page import="com.green.entity.Course"%>
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
	<%
	Course course = (Course) request.getAttribute("_course");
	List<Lesson> lessonlist = (List<Lesson>) request.getAttribute("_lessonlist");
	CourseSubjects courseSubjects = (CourseSubjects) request.getAttribute("_courseSubjects");
	%>
<div class="full-width" >
	<div class="container">
		<div class="row" style="height: 80px;">
		</div>
		
		<div class="row">
			<div class="col-md-8">
				<div class="course-intro">
					<h1><%=course.getName() %></h1>
					<div style="font-size: 21px;font-family: tahoma;"><%=course.getShortdesc() %></div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="container page">
	
		<div class="row course-content-mid">
			<div class="col-md-8">
			<div class="course-use-title" style="font-size: 28px;margin: 10px;"><b>Môn <%=courseSubjects.getSubjects().getName() %></b></div>
			
			<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Tên</th>
	      <th scope="col">Mô tả</th>
	      <th scope="col">Tùy chọn</th>
	    </tr>
	  </thead>
	  <tbody>
<%
	for(Lesson lesson : lessonlist) {
%>
	    <tr>
	      <th scope="row"><%=lesson.getSeq() %></th>
	      <td><%=lesson.getName() %></td>
	      <td><%=lesson.getDescription() %></td>
	      <td>
	      	<form class="action-form" action="<%=request.getContextPath()%>/learning/lesson/<%=courseSubjects.getId()%>" method="get">
	      		<button type="submit">Chọn</button>
	      	</form>
	      </td>
	    </tr>
<% } %>
	  </tbody>
	</table>
			</div>
		</div>
		
		
		<div class="row" style="height: 20px;"></div>
		
		<div class="row course-requirement">
		<div class="col-md-8">
			<div class="course-use-title" style="font-size: 28px;margin: 10px;"><b>Yêu cầu khóa học</b></div>
			<div>
				<%=course.getRequiment() %>
			</div>
		</div>
		</div>
		
		<div class="row" style="height: 20px;"></div>
		
		<div class="row course-decription">
		<div class="col-md-8">
			<div class="course-use-title" style="font-size: 28px;margin: 10px;"><b>Nội dung khóa học</b></div>
			<div class="row course-decription-content">
					<p><%=course.getDescription() %></p>
			</div>
		</div>
		</div>
		
		<div class="row" style="height: 50px;"></div>
		
		<div class="row course-author">
		<div class="col-md-2">
			<div style="margin-left: 20px;">
				<img class="author-avatar" alt="" src="<%=request.getContextPath()%>/image/profile/<%=course.getAuthor().getAvatar() %>" width="120" height="120">
			</div>
			<div style="font-size: 14px; margin-top: 10px;">
				<ul>
					<li>78.5 Instructor Rating</li>
					<li>5 Reviews</li>
					<li>36 Students</li>
					<li>Full Courses</li>
				</ul>
			</div>
		</div>
		<div class="col-md-6" style="margin-left: 50px; ">
			<div class="course-author-name" style="text-decoration: none;">
				<a href="<%=request.getContextPath()%>/profile/<%=course.getAuthor().getAccountId()%>"><b><h3><%=course.getAuthor().getFullName() %></h3></b></a>
				<b>Java Python Android and C# Expert Developer - 532K+ students</b>
			</div>
			<div class="course-author-decription" style="margin-top: 30px;">
				<p>You’ve just stumbled upon the most complete, in-depth Java programming course online. With over 260,000 students enrolled and tens of thousands of 5 star reviews to date, these comprehensive java tutorials cover everything you’ll ever need.</p>
			</div>
		</div>
		</div>
		
		<div class="row" style="height: 50px;"></div>
	
</div>

<jsp:include page="../../component/footer.jsp"></jsp:include>

<%-- import js files --%>
<jsp:include page="../../component/common-js.jsp"></jsp:include>
</body>
</html>
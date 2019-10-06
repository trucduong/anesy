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
	List<CourseSubjects> courseSubjectlist = (List<CourseSubjects>) request.getAttribute("_courseSubjectlist");
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
			<div class="course-use-title" style="font-size: 28px;margin: 10px;"><b>Giáo trình môn học</b></div>
			
			<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">Bài</th>
	      <th scope="col">Tên</th>
	      <th scope="col">Mô tả</th>
	      <th scope="col">Tùy chọn</th>
	    </tr>
	  </thead>
	  <tbody>
<%
	for(CourseSubjects courseSubjects : courseSubjectlist) {
%>
	    <tr>
	      <th scope="row"><%=courseSubjects.getSeq() %></th>
	      <td><%=courseSubjects.getSubjects().getName() %></td>
	      <td><%=courseSubjects.getSubjects().getDescription() %></td>
	      <td>
	      	<form class="action-form" action="<%=request.getContextPath()%>/learning/course/<%=course.getId() %>/subject/<%=courseSubjects.getId()%>" method="get">
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
				<img class="author-avatar" alt="" src="<%=request.getContextPath()%>/image/profile/<%=course.getAuthor().getAccountId() %>" width="120" height="120">
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
				<b><%=course.getAuthor().getSpecialize() %></b>
			</div>
			<div class="course-author-decription" style="margin-top: 30px;">
				<p><%=course.getAuthor().getDescription() %></p>
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
<%@page import="com.green.entity.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<%@ taglib prefix = "anesy" uri="/WEB-INF/anesy.tld"%>
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
		List<Course> courseList = (List<Course>) request.getAttribute("_courselist");
	%>
	<jsp:include page="../../component/header.jsp"></jsp:include>

	<div class="container page">
		<div class="row">
			<div class="col-md-4">

			<jsp:include page="../../component/profilelistgroup.jsp"></jsp:include>

			</div>
			<div class="col-md-7">
			 <%-- <anesy:course-list courses="${_courselist}"></anesy:course-list> --%>
				<div class="card">
					<h5 class="card-header">Khóa học của tôi</h5>
					<div class="card-body">
						<div class="card-columns">
						<%for(Course course : courseList){ %>
							<a href="<%=request.getContextPath()%>/learning/course/<%=course.getId()%>"> 
							<div class="card" style="min-height: 300px;">
								<img src="<%=request.getContextPath()%>/image/course/<%=course.getAvatar() %>" class="card-img-top"
									alt="Java Programming Masterclass for Software Developers">
								<div class="card-body">
									<h5 class="card-title" style="font-size: 15px;"><%=course.getName() %></h5>
								</div>
							</div>
							</a>
							<%} %>
							
						</div>
						
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
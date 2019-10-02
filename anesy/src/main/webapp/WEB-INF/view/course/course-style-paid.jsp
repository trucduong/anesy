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
	List<CourseComment> commentList = (List<CourseComment>) request.getAttribute("_comment");
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
		
		<div class="row" style="height: 20px;"></div>
		
		<div class="row course-content-mid">
			<div class="col-md-8">
			<div class="course-use-title" style="font-size: 28px;margin: 10px;"><b>Giáo trình</b></div>
			
			<h4 style="margin-top: 10px;margin-bottom: 20px;">Phần 1: Tổng quan về Java </h4>
			<a href="#" style="outline: none !important; text-decoration: none;" >
			<table class="table-lesson" style="margin-bottom: 15px;" > 
				<tbody>
					<tr>
						<td class="col-status" width="80px;" ><i class="material-icons" style="font-size: 40px;"> settings_ethernet</i></td>
						<td class="col-name" style="width: 600px;">
							<div class="lesson-name" style="float: left ">Bài 1: Lesson Name</div>
							<div class="lesson-time" style="text-align: right; ">10:00</div>
						</td>
					</tr>
				</tbody>
			</table>
			</a>
			
			<a href="#" style="outline: none !important; text-decoration: none;" >
			<table class="table-lesson" style="margin-bottom: 15px;" > 
				<tbody>
					<tr>
						<td class="col-status" width="80px;" ><i class="material-icons" style="font-size: 40px;"> settings_ethernet</i></td>
						<td class="col-name" style="width: 600px;">
							<div class="lesson-name" style="float: left ">Bài 1 : Lesson Name</div>
							<div class="lesson-time" style="text-align: right; ">10:00</div>
						</td>
					</tr>
				</tbody>
			</table>
			</a>
			
			
			
			</div>
		</div>
		
		<div class="row" style="height: 20px;"></div>
		
		<div class="row course-requirement">
		<div class="col-md-8">
			<div class="course-use-title" style="font-size: 28px;margin: 10px;"><b>Mô tả khóa học</b></div>
			<h5>Tổng quát</h5>
			<div>
				<%=course.getDescription() %>
			</div>
			<h5>Yêu cầu của khóa học</h5>
			<div>
				<%=course.getRequiment() %>
			</div>
			<h5>Lợi ích từ khóa học</h5>
			<div>
				<%=course.getBenefit() %>
			</div>
			
		</div>
		</div>
		
		<div class="row" style="height: 20px;"></div>
		
		
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
				<b></b>
			</div>
			<div class="course-author-decription" style="margin-top: 30px;">
				<p>You’ve just stumbled upon the most complete, in-depth Java programming course online. With over 260,000 students enrolled and tens of thousands of 5 star reviews to date, these comprehensive java tutorials cover everything you’ll ever need.</p>
			</div>
		</div>
		</div>
		
		<div class="row" style="height: 50px;"></div>
		
		<h2>Bình luận</h2>
		<form action="<%=request.getContextPath()%>/course/comment" method="post">
		<input type="hidden" name="courseId" value="<%=course.getId()%>">
		<div class="form-group">
				<div id="editor"></div>
				<input id="editorVal" name="comment" type="hidden" value="">
		</div>
		<button type="submit" class="btn btn-primary">Bình luận</button>
		</form>
		<div class="row" style="height: 50px;"></div>
		<div class="course-use-title" style="font-size: 28px; padding-bottom: 20px;"><b>Bình luận của mọi người</b></div>
		<%for(CourseComment comment : commentList){ %>
		<div class="row course-comment">		
			<div class="col-md-2">
			<div style="margin-left: 20px;">
				<img class="people-avatar" alt="" src="<%=request.getContextPath()%>/image/profile/<%=comment.getAuthor().getAvatar() %>" width="50" height="50">
			</div>
			<div style="font-size: 14px; margin-top: 10px; " >
				<div><b><%=comment.getAuthor().getFullName() %></b></div>
				<div><%=comment.getCreatedAt() %></div>
			</div>
			</div>
		<div class="col-md-6" style="margin-left: 50px; ">
			<div class="point-comment"></div>
			<div class="comment-content" style="margin-top: 30px;">
					<p><%=comment.getContent() %></p>
			</div>
		</div>
		</div>
		<hr>
		<%} %>
</div>

<jsp:include page="../../component/footer.jsp"></jsp:include>

<%-- import js files --%>
<jsp:include page="../../component/common-js.jsp"></jsp:include>
<script type="text/javascript">

function handleCancel() {
	location.href="<%=request.getContextPath()%>/admin/course";
}

$( document ).ready(function() {

	ClassicEditor
	.create( document.querySelector( '#editor' ) )
	.then(editor => {
		
		editor.setData( '${_course.requiment}' );
		
		editor.model.document.on( 'change:data', () => {
		    document.getElementById('editorVal').value = editor.getData();
		});
	})
	.catch( error => {
		console.error( error );
	});
	
});

</script>
</body>
</html>
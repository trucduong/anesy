<%@page import="com.green.entity.CourseSubjects"%>
<%@page import="java.util.List"%>
<%@page import="com.green.entity.Course"%>
<%@page import="com.green.entity.Subjects"%>
<%@page import="com.green.model.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subjects Detail</title>

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
	CourseSubjects courseSubjects = (CourseSubjects) request.getAttribute("_subjectsCourse");
	List<Course> courseList = (List<Course>)  request.getAttribute("_courseList");
%>

<h1 class="page-title">Môn học</h1>

<div class="row justify-content-center mb-4">
	<div class="col-md-12">
		<form method="post">
			
			<input name="id" type="hidden" value=${_category.id}>
			
			<div class="form-group">
				<div class="custom-file image-box" >
					<input id="subImgVal" name="avatar" type="hidden" value="${_subjects.avatar}">
					<input id="subImgFile" type="file" class="custom-file-input" onchange="doUpload('subjects', 'sub')">
					<img id="subImg" alt="Subjects" src="<%=request.getContextPath()%>/image/subjects/${_subjects.avatar}">
				</div>
			</div>
			
			<div class="form-group">
				<label for="subName">Subjects Name</label>
				<input name="name" type="text" class="form-control" id="subName" placeholder="Enter subject name" value="${_subjects.name}">
			</div>
			
			<div class="form-group">
				<label>Description</label>
				<div id="editor"></div>
				<input id="editorVal" name="description" type="hidden" value="${_subjects.description}">
			</div>
			
			<div class="form-group">
				<label>Course Name</label>
				<select name="subjectsId">
							<%
								for (Course course : courseList) {
							%>
							<option value="<%=course.getId()%>"
								<%=(courseSubjects.getCourse()!=null  && courseSubjects.getCourse().getId() == course.getId()) ? "selected" : ""%>><%=course.getName()%></option>
							<%
								}
							%>
					</select>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="button" onclick="handleCancel()" class="btn btn-default">Cancel</button>
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

<script type="text/javascript">


function handleCancel() {
	location.href="<%=request.getContextPath()%>/admin/subjects";
}

$( document ).ready(function() {

	ClassicEditor
	.create( document.querySelector( '#editor' ) )
	.then(editor => {
		
		editor.setData( '${_subjects.description}' );
		
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
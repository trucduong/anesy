<%@page import="com.green.entity.Lesson"%>
<%@page import="java.util.List"%>
<%@page import="com.green.entity.Subjects"%>
<%@page import="com.green.entity.CourseCategory"%>
<%@page import="com.green.model.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lesson Detail</title>

<%-- import css files --%>
<jsp:include page="../../component/common-css.jsp"></jsp:include>

</head>
<body>
<jsp:include page="../../component/header.jsp"></jsp:include>

<div class="container page">
<div class="row">
<div class=col-md-3></div>
<div class="col-md-8">

<%
Lesson lesson = (Lesson) request.getAttribute("_lesson");
List<Subjects> subjectList = (List<Subjects>) request.getAttribute("_subjectList");
%>

<h1 class="page-title">Lesson</h1>

<div class="row justify-content-center mb-4">
	<div class="col-md-12">
		<form method="post">
			
			<input name="id" type="hidden" value="${_lesson.id}">
			
			<div class="form-group">
				<label for="lesName">Lesson Name</label>
				<input name="name" type="text" class="form-control" id="lesName" placeholder="Enter lesson name" value="${_lesson.name}">
			</div>
			
			<div class="form-group">
				<label>Description</label>
				<div id="editor"></div>
				<input id="editorVal" name="description" type="hidden" value="${_lesson.description}">
			</div>
			
			<div class="form-group">
				<label>Subject Name</label>
				<select name="subjectsId">
							<%
								for (Subjects subject : subjectList) {
							%>
							<option value="<%=subject.getId()%>"
								<%=(lesson.getSubjects()!=null && lesson.getSubjects().getId() == subject.getId()) ? "selected" : ""%>><%=subject.getName()%></option>
							<%
								}
							%>
					</select>
			</div>
			
			<div class="form-group">
				<label>Sequence</label>
				<input name="seq" value="${_lesson.seq}">
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="button" onclick="handleCancel()" class="btn btn-default">Cancel</button>
		</form>
	</div>
</div>

</div>
<div class="col-md-1"></div>
</div>
</div>

<jsp:include page="../../component/footer.jsp"></jsp:include>

<%-- import js files --%>
<jsp:include page="../../component/common-js.jsp"></jsp:include>

<script type="text/javascript">
function handleCancel() {
	location.href="<%=request.getContextPath()%>/admin/lesson";
}

$( document ).ready(function() {

	ClassicEditor
	.create( document.querySelector( '#editor' ) )
	.then(editor => {
		
		editor.setData( '${_lesson.description}' );
		
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
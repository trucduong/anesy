<%@page import="com.green.entity.Subjects"%>
<%@page import="java.util.List"%>
<%@page import="com.green.entity.Exercise"%>
<%@page import="com.green.model.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercise Detail</title>

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
Exercise exercise = (Exercise) request.getAttribute("_exercise");
List<Subjects> subjectList = (List<Subjects>) request.getAttribute("_subjectList");
%>

<h1 class="page-title">Exercise</h1>

<div class="row justify-content-center mb-4">
	<div class="col-md-12">
		<form method="post">
			
			<input name="id" type="hidden" value=${_exercise.id}>
			
			
			
			<div class="form-group">
				<label for="subName">Exercise Name</label>
				<input name="name" type="text" class="form-control" id="subName" placeholder="Enter exercise name" value="${_exercise.name}">
			</div>
			
			<div class="form-group">
				<label>Description</label>
				<div id="editor"></div>
				<input id="editorVal" name="description" type="hidden" value="${_exercise.description}">
			</div>
			
			<div class="form-group">
				<label>Subject Name</label>
				<select name="subjectsId">
							<%
								for (Subjects subject : subjectList) {
							%>
							<option value="<%=subject.getId()%>"
								<%=(exercise.getSubjects()!=null && exercise.getSubjects().getId() == subject.getId()) ? "selected" : ""%>><%=subject.getName()%></option>
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
</div>
</div>

<jsp:include page="../../component/footer.jsp"></jsp:include>

<%-- import js files --%>
<jsp:include page="../../component/common-js.jsp"></jsp:include>

<script type="text/javascript">


function handleCancel() {
	location.href="<%=request.getContextPath()%>/admin/exercise";
}

$( document ).ready(function() {

	ClassicEditor
	.create( document.querySelector( '#editor' ) )
	.then(editor => {
		
		editor.setData( '${_exercise.description}' );
		
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
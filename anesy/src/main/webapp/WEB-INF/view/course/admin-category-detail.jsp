<%@page import="com.green.entity.CourseCategory"%>
<%@page import="com.green.model.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course Category Detail</title>

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
	
%>

<h1 class="page-title">Category</h1>

<div class="row justify-content-center mb-4">
	<div class="col-md-12">
		<form method="post">
			
			<input name="id" type="hidden" value="${_category.id}">
			
			<div class="form-group">
				<div class="custom-file image-box" >
					<input id="catImgVal" name="avatar" type="hidden" value="${_category.avatar}">
					<input id="catImgFile" type="file" class="custom-file-input" onchange="doUpload('category', 'cat');">
					<img id="catImg" alt="Category" src="<%=request.getContextPath()%>/image/category/${_category.avatar}">
				</div>
			</div>
			
			<div class="form-group">
				<label for="catName">Category Name</label>
				<input name="name" type="text" class="form-control" id="catName" placeholder="Enter course category name" value="${_category.name}">
			</div>
			
			<div class="form-group">
				<label>Description</label>
				<div id="editor"></div>
				<input id="editorVal" name="description" type="hidden" value="${_category.description}">
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
	location.href="<%=request.getContextPath()%>/admin/course-category";
}

$( document ).ready(function() {

	ClassicEditor
	.create( document.querySelector( '#editor' ) )
	.then(editor => {
		
		editor.setData( '${_category.description}' );
		
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
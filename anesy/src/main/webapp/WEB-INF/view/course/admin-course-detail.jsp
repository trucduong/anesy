<%@page import="com.green.entity.CourseCategory"%>
<%@page import="com.green.model.Page"%>
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

<div class="container page">
<div class="row">
<div class="col-md-3"><jsp:include page="../../component/left.jsp"></jsp:include></div>
<div class="col-md-8">

<%
	
%>

<h1 class="page-title">Khóa học</h1>

<div class="row justify-content-center mb-4">
	<div class="col-md-12">
		<form method="post">
			
			<input name="id" type="hidden" value="${_course.id}">
			
			<div class="form-group">
				<div class="custom-file image-box" >
					<input id="courseImgVal" name="avatar" type="hidden" value="${_course.avatar}">
					<input id="courseImgFile" type="file" class="custom-file-input" onchange="doUpload('course', 'course');">
					<img id="courseImg" alt="Course" src="<%=request.getContextPath()%>/image/course/${_course.avatar}">
				</div>
			</div>
			
			<div class="form-group">
				<label >Course Name</label>
				<input name="name" type="text" class="form-control" id="catName" placeholder="Enter course name" value="${_course.name}">
			</div>
			
			<div class="form-group">
				<label >Short Description</label>
				<input name="shortdesc" type="text" class="form-control" id="catName" placeholder="Enter course short decription" value="${_course.shortdesc}">
			</div>
			
			<div class="form-group">
				<label>Description</label>
				<div id="editor"></div>
				<input id="editorVal" name="description" type="hidden" value="${_course.description}">
			</div>
			
			<div class="form-group">
				<label>Benefit</label>
				<div id="editor1"></div>
				<input id="editorVal" name="benefit" type="hidden" value="${_course.benefit}">
			</div>
			
			<div class="form-group">
				<label>Requiment</label>
				<div id="editor2"></div>
				<input id="editorVal" name="requiment" type="hidden" value="${_course.requiment}">
			</div>
			
			<div class="form-group">
				<label>Include</label>
				<div id="editor3"></div>
				<input id="editorVal" name="include" type="hidden" value="${_course.include}">
			</div>
			
			<div class="form-group">
				<label >Price</label>
				<input name="price" type="text" class="form-control" id="catName" placeholder="Enter course price" value="${_course.price}">
			</div>
			
			
			
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalReview">
 			 		Review
			</button>
			<div class="modal fade" id="modalReview" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Review Course</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body mb-0 p-0">
				        <div class="embed-responsive embed-responsive-16by9 z-depth-1-half">
				          <iframe class="embed-responsive-item" src="/course/course-style.jsp" allowfullscreen></iframe>
				        </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <button type="submit" class="btn btn-primary">Save changes</button>
			      </div>
			    </div>
			  </div>
			</div>
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
	location.href="<%=request.getContextPath()%>/admin/course";
}

$( document ).ready(function() {

	ClassicEditor
	.create( document.querySelector( '#editor1' ) )
	.then(editor => {
		
		editor.setData( '${_course.description}' );
		
		editor.model.document.on( 'change:data', () => {
		    document.getElementById('editorVal').value = editor.getData();
		});
	})
	.catch( error => {
		console.error( error );
	});
	
});

</script>


<script type="text/javascript">

function handleCancel() {
	location.href="<%=request.getContextPath()%>/admin/course";
}

$( document ).ready(function() {

	ClassicEditor
	.create( document.querySelector( '#editor2' ) )
	.then(editor => {
		
		editor.setData( '${_course.benefit}' );
		
		editor.model.document.on( 'change:data', () => {
		    document.getElementById('editorVal').value = editor.getData();
		});
	})
	.catch( error => {
		console.error( error );
	});
	
});

</script>

<script type="text/javascript">

function handleCancel() {
	location.href="<%=request.getContextPath()%>/admin/course";
}

$( document ).ready(function() {

	ClassicEditor
	.create( document.querySelector( '#editor3' ) )
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

<script type="text/javascript">

function handleCancel() {
	location.href="<%=request.getContextPath()%>/admin/course";
}

$( document ).ready(function() {

	ClassicEditor
	.create( document.querySelector( '#editor' ) )
	.then(editor => {
		
		editor.setData( '${_course.include}' );
		
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
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
				<div id="description"></div>
				<input id="descriptionVal" name="description" type="hidden" value="${_course.description}">
			</div>
			
			<div class="form-group">
				<label>Benefit</label>
				<div id="benefit"></div>
				<input id="benefitVal" name="benefit" type="hidden" value="${_course.benefit}">
			</div>
			
			<div class="form-group">
				<label>Requirement</label>
				<div id="requiment"></div>
				<input id="requimentVal" name="requiment" type="hidden" value="${_course.requiment}">
			</div>
			
			<div class="form-group">
				<label>Include</label>
				<div id="include"></div>
				<input id="includeVal" name="include" type="hidden" value="${_course.include}">
			</div>
			
			<div class="form-group">
				<label >Price</label>
				<input name="price" type="text" class="form-control" id="catName" placeholder="Enter course price" value="${_course.price}">
			</div>
			
			
			<input type="submit" name ="action" value="submit" class="btn btn-primary">
			
			<input type="submit" name ="action" value="preview" class="btn btn-danger">
			
			<button type="button" onclick="handleCancel()" class="btn btn-default">Cancel</button>
		</form>
	</div>
</div>

<%
if (session.getAttribute("course_preview") != null) {
%>
<div class="modal fade" id="courseReviewModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" >Review Course</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body mb-0 p-0">
	        <div class="embed-responsive embed-responsive-16by9 z-depth-1-half">
	          <iframe class="embed-responsive-item" src="<%=request.getContextPath()%>/admin/course/preview" allowfullscreen></iframe>
	        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<% } %>
			
</div>
<div class="col-md-1"><jsp:include page="../../component/right.jsp"></jsp:include></div>
</div>
</div>

<jsp:include page="../../component/footer.jsp"></jsp:include>

<%-- import js files --%>
<jsp:include page="../../component/common-js.jsp"></jsp:include>

<script type="text/javascript">

$( document ).ready(function() {
	if ($('#courseReviewModal')) {
		$('#courseReviewModal').modal('show');
	}
});

function handleCancel() {
	location.href="<%=request.getContextPath()%>/admin/course";
}

$( document ).ready(function() {

	var editors = ['description', 'benefit','requiment','include'];
	editors.forEach(function(editorId) {
		ClassicEditor
		.create( document.querySelector( '#' + editorId ) )
		.then(editor => {
			
			editor.setData(document.getElementById(editorId + 'Val').value);
			
			editor.model.document.on( 'change:data', () => {
			    document.getElementById(editorId + 'Val').value = editor.getData();
			});
		})
		.catch( error => {
			console.error( error );
		});
	});
	
});

</script>


</body>
</html>
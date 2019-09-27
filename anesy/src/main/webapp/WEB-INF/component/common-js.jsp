<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="<%=request.getContextPath() %>/resources/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/lib/jquery/jquery.slim.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/lib/bootstrap/js/bootstrap-tagsinput.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/lib/ckeditor/ckeditor.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/resources/main/js/main.js"></script>


<script>
$( document ).ready(function() {
	if ($('#msgBoxModal')) {
		$('#msgBoxModal').modal('show');
	}
});
</script>
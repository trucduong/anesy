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
			<div class="col-md-4">

				<jsp:include page="../../component/profilelistgroup.jsp"></jsp:include>

			</div>
			<div class="col-md-7">
				<div class="card">
					<h5 class="card-header">Lịch Sử Học Tập</h5>
					<div class="card-body">

						
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
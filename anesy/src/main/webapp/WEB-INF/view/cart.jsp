<%@page import="com.green.entity.Profile"%>
<%@page import="com.green.entity.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="../component/header.jsp"></jsp:include>

	
	<div class="full-width-name"
		style="height: 150px; background-color: #ffe494; margin-bottom: 50px;">
		<div class="teacher-name" style="padding: 50px 150px;">
			<b><h2>Shopping Cart</h2></b>
		</div>
	</div>
	<div class="container page">
		<div style="margin-bottom: 10px;"><b><h5>1 Khóa học trong giỏ hàng</h5></b></div>
		<div class="row">
			<div class="col-md-9">
			<div class="card mb-3" style="max-height: 130px;">
				<div class="row no-gutters">
					<div class="col-md-2">
						<img
							src="<%=request.getContextPath()%>/resources/image/avatar-comment-image/hinh2.jpg"
							class="card-img" alt="" >
					</div>
					<div class="col-md-6">
						<div class="card-body">
							<h5 class="card-title">Java</h5>
							<p class="card-text">
								<small class="text-muted"></small>
							</p>
							<p class="card-text">haha</p>
							<p class="card-text">haha</p>
						</div>
					</div>
					<div class="col-md-2">
						<div class="giatien">
							<a href="#">Remove</a>
						</div>
					</div>
					<div class="col-md-2">
						<div class="giatien">
							<b>100000 VNĐ</b>
						</div>
						<div class="giatien">
						<span class="oi oi-star"><%=5%></span>
						</div>
					</div>
				</div>
			</div>
			</div>
			<div class="col-md-3">
				<div class="total">
					<i><h5>Tổng cộng :</h5></i>
					<b><h2>100000 VND</h2></b>
				</div>
					<button type="button" class="btn btn-danger btn-lg btn-block">Thanh toán</button>
				
			</div>
		</div>
								
	</div>

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
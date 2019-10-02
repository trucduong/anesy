<%@page import="com.green.entity.Cart"%>
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
	
	<%
		Cart cart = (Cart) session.getAttribute("CART");
		long total = cart.getTotal();
	%>
	
	<div class="full-width-name"
		style="height: 150px; background-color: #ffe494; margin-bottom: 50px;">
		<div class="teacher-name" style="padding: 50px 150px;">
			<b><h2>Shopping Cart</h2></b>
		</div>
	</div>
	<div class="container page">
		<div style="margin-bottom: 10px;"><b><h5><%=cart.getDetails().size() %> Khóa học trong giỏ hàng</h5></b></div>
		<div class="row">
			<div class="col-md-9">
			<%
					for (int code : cart.getDetails().keySet()) {
						Course course = cart.getDetails().get(code);
				%>
			<div class="card mb-3" style="max-height: 130px;">
				<div class="row no-gutters">
					<div class="col-md-2">
						<img
							src="<%=request.getContextPath()%>/image/course/<%=course.getAvatar() %>"
							class="card-img" alt="" >
					</div>
					<div class="col-md-6">
						<div class="card-body">
							<h5 class="card-title"><%=course.getName() %></h5>
							<p class="card-text">
								<small class="text-muted"><%=course.getShortdesc() %></small>
							</p>
						</div>
					</div>
					<div class="col-md-2">
						<div class="giatien">
							<form action="<%=request.getContextPath()%>/cart/remove" method="post">
							<input type="hidden" name="courseId"
								value=<%=course.getId()%>> 
							<button type="submit" value="remove">Remove</button>
						</form>
						</div>
					</div>
					<div class="col-md-2">
						<div class="giatien">
							<b><%=course.getPrice() %> VNĐ</b>
						</div>
						<div class="giatien">
						<span class="oi oi-star"><%=5%></span>
						</div>
					</div>
				</div>
			</div>
			<%} %>
			</div>
			<div class="col-md-3">
				<div class="total">
					<i><h5>Tổng cộng :</h5></i>
					<b><h2><%=cart.getTotal() %> VND</h2></b>
				</div>
					<button type="button" class="btn btn-danger btn-lg btn-block" data-toggle="modal" data-target="#exampleModalScrollable">
							 Thanh toán
					</button>
				<form action="<%=request.getContextPath()%>/cart/pay" method="post">
				<div class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
				  <div class="modal-dialog modal-dialog-scrollable" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="exampleModalScrollableTitle">Xác nhận thanh toán </h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        Bạn có chắc chắn xác nhận thanh toán <%=cart.getTotal()%> VND 
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
				        <button type="summit" class="btn btn-primary">Xác nhận</button>
				      </div>
				    </div>
				  </div>
			</div>
			</form>
			</div>
		</div>
								
	</div>

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
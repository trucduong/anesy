<%@ page import="com.green.entity.Profile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>
<link href="datepicker/css/datepicker.css" rel="stylesheet" />
</head>
<body>

	<% Profile profile =(Profile) request.getAttribute("_profile-info"); %>
	
	<jsp:include page="../component/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="card">
					<h5 class="card-header">...</h5>
					<div class="card-body">



						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text left" id="inputGroupFileAddon01">Upload</span>
							</div>
							<div class="custom-file">
								<input type="file" class="custom-file-input"
									id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
								<label class="custom-file-label" for="inputGroupFile01">Choose
									file</label>
							</div>
						</div>




						<div style="display: inline-block;">
							<img alt="Ảnh đại diện"
								src="<%=request.getContextPath()%>/product/image?code=${_product.code}"
								width="100" height="100">
						</div>
						<div>
							<form
								action="<%=request.getContextPath()%>/product/image?code=${_product.code}"
								method="post" enctype="multipart/form-data">
								<input type="file" name="file" />
								<button class="btn btn-primary" type="submit">Tải ảnh</button>
							</form>
						</div>
						<div class="btn-group-vertical">
							<a href="<%=request.getContextPath()%>/profile/info"><button
									type="button" class="btn btn-light">Thông Tin Cá Nhân</button></a>
							<a href="<%=request.getContextPath()%>/profile/password">
								<button type="button" class="btn btn-light">Tài Khoản</button>
							</a> <a href="<%=request.getContextPath()%>/profile/history"><button
									type="button" class="btn btn-light">Lịch Sử Học Tập</button></a> <a
								href="<%=request.getContextPath()%>/profile/certificate"><button
									type="button" class="btn btn-light">Chứng Chỉ</button></a>
						</div>
					</div>
				</div>


			</div>
			<div class="col-md-7">
				<div class="card">
					<h5 class="card-header">Thông Tin Cá Nhân</h5>
					<div class="card-body">

						<form action="<%=request.getContextPath()%>/profile/info" method="post">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Họ
										và tên</span>
								</div>
								<input name="name" type="text" class="form-control" value="<%=profile.getFullName() %>"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Số
										điện thoại</span>
								</div>
								<input name="phone" type="text" class="form-control" value="<%=profile.getPhone() %>"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Email</span>
								</div>
								<input name="email" type="text" class="form-control" value="<%=profile.getEmail() %>"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Ngày
										sinh </span>
								</div>
								<input id="checkin" name="birthday" type="date" value="<%=profile.getBirthDate() %>"
									class="form-control" aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<label class="input-group-text" for="inputGroupSelect01">Giới
										tính</label>
								</div>
								<select name="gender" class="custom-select" value="<%=profile.getGender() %>"
									id="inputGroupSelect01">
									<option selected>Vui lòng chọn</option>
									<option value="1">Nam</option>
									<option value="2">Nữ</option>
								</select>
							</div>


							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Địa
										Chỉ</span>
								</div>
								<textarea name="address" type="text" class="form-control" id="email" value="<%=profile.getAddress() %>"
									required=""
									data-validation-required-message="Please enter your email address."></textarea>
							</div>


							<div id="success"></div>
							<button type="submit" class="btn btn-primary"
								id="sendMessageButton">Cập Nhật</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
	<script src="datepicker/js/jquery.min.js"></script>
	<script src="datepicker/js/bootstrap.min.js"></script>
	<script src="datepicker/js/bootstrap-datepicker.js"></script>


	<script>
		$(function() {
			'use strict';
			var nowTemp = new Date();
			var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(),
					nowTemp.getDate(), 0, 0, 0, 0);

			var checkin = $('#checkin').datepicker({
				onRender : function(date) {
					return date.valueOf() < now.valueOf() ? 'disabled' : '';
				}
			}).on('changeDate', function(ev) {
				if (ev.date.valueOf() > checkout.date.valueOf()) {
					var newDate = new Date(ev.date)
					newDate.setDate(newDate.getDate() + 1);
					checkout.setValue(newDate);
				}
				checkin.hide();
			}).data('datepicker');
		});
	</script>
</body>
</html>


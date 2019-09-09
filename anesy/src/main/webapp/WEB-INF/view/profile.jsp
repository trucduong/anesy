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

	<div class="container">
		<div class="row">
			<div class="col-md-4">â</div>
			<div class="col-md-5">
				<h3>Thông Tin Cá Nhân</h3>
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
						<button type="submit">Tải ảnh</button>
					</form>
				</div>
				<form >
					<div class="control-group form-group">
						<div class="controls">
							<label>Họ Và Tên</label> <input type="text" class="form-control"
								id="name" required=""
								data-validation-required-message="Please enter your name."
								aria-invalid="false">
							<p class="help-block"></p>
						</div>
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>Số Điện Thoại</label> <input type="tel"
								class="form-control" id="phone" required=""
								data-validation-required-message="Please enter your phone number.">
							<div class="help-block"></div>
						</div>
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>Email</label> <input type="email" class="form-control"
								id="email" required=""
								data-validation-required-message="Please enter your email address.">
							<div class="help-block"></div>
						</div>
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>Ngày Sinh</label> <input type="address"
								class="form-control" id="email" required=""
								data-validation-required-message="Please enter your email address.">
							<div class="help-block"></div>
						</div>
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>Giới Tính</label> <input type="gender"
								class="form-control" id="email" required=""
								data-validation-required-message="Please enter your email address.">
							<div class="help-block"></div>
						</div>
					</div>
					<div class="control-group form-group">
						<div class="controls">
							<label>Địa Chỉ</label> <textarea type="text" class="form-control"
								id="email" required=""
								data-validation-required-message="Please enter your email address."></textarea>
							<div class="help-block"></div>
						</div>
					</div>
					
					
					<div id="success"></div>
					<button type="submit" class="btn btn-primary"
						id="sendMessageButton">Cập Nhật</button>
				</form>
			</div>

		</div>
	</div>

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>

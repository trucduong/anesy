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
			<div class="col-md-4">
				<div class="card">
					<h5 class="card-header">...</h5>
					<div class="card-body">
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
								<button type="button" class="btn btn-light">Tài Khoản</button></a> 
							<a href="<%=request.getContextPath()%>/profile/history"><button
									type="button" class="btn btn-light">Lịch Sử Học Tập</button></a> 
							<a href="<%=request.getContextPath()%>/profile/certificate"><button
									type="button" class="btn btn-light">Chứng Chỉ</button></a>
						</div>
					</div>
				</div>


			</div>
			<div class="col-md-7">
				<div class="card">
					<h5 class="card-header">Chứng Chỉ</h5>
					<div class="card-body">

						<form>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Họ
										và tên</span>
								</div>
								<input type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Số
										điện thoại</span>
								</div>
								<input type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Email</span>
								</div>
								<input type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Giới
										tính</span>
								</div>
								<input type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Ngày
										Sinh</span>
								</div>
								<input type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Địa
										Chỉ</span>
								</div>
								<textarea type="text" class="form-control" id="email"
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

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
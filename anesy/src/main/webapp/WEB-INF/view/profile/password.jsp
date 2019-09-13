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
			<div class="col-md-8">
				<div class="card">
					<h5 class="card-header">Tài Khoản</h5>
					<div class="card-body">
						<form >
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Mật
										Khẩu Hiện Tại</span>
								</div>
								<input name="oldpass" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Mật
										khẩu mới</span>
								</div>
								<input name="newpass" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Nhập
										lại mật khẩu</span>
								</div>
								<input name="newpass1" type="text" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>


							<div id="success"></div>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal">Xác Nhận</button>
							<!-- Modal -->
							<div class="modal fade" id="exampleModal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Xác Nhận
												Thay Đổi</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">...</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Thoát</button>
											<button type="submit" type="button" class="btn btn-primary">Cập
												nhật</button>
										</div>
									</div>
								</div>
							</div>
						</form>
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







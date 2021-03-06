<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 85%;
}

td, th {
	text-align: left;
	padding: 10px;
	width: 90%;
}

h2 {
	text-align: center;
	font-size: 180%;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="../component/header.jsp"></jsp:include>
	<div class="container" style="min-height: 622px">
		<div class="row justify-content-center">
			<div class="col-md-6 mt-5">
			<form action="<%=request.getContextPath()%>/regis" method="post" style="display: unset !important;">
				<div class="card text-center">
					<div class="card-header">Đăng ký tài khoản</div>
					<div class="card-body">
							<table align="center">
								<tr>
									<td>Email</td>
									<td><input name="email" type="text"></td>
								</tr>
								<tr>
									<td>Họ và tên</td>
									<td><input name="fullName" type="text"></td>
								</tr>
								<tr>
									<td>User Type</td>
									<td><select name="userType">
											<option value="1">Học viên</option>
											<option value="2">Giáo viên</option>
											<option value="3">Trung tâm</option>
									</select></td>
								</tr>
								<tr>
									<td colspan="2" style="text-align: center;">
										<button class="btn btn-primary" type="submit">Đăng ký</button>
									</td>
								</tr>
							</table>
					</div>
					<div class="card-footer text-muted">
						<a href="<%=request.getContextPath()%>">Trở Về Trang Chủ</a>
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
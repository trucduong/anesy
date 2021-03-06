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
	width: 10%;
}

h2 {
	text-align: center;
	font-size: 180%;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forgot Password</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="../component/header.jsp"></jsp:include>

	<div class="page-container" style="min-height: 622px">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6" style="padding: 2.75rem;">
				<div class="card text-center">
					<div class="card-header">Forgot password</div>
					<div class="card-body">
						<form action="<%=request.getContextPath()%>/resetpass" method="post">
							<table align="center">
								<tr>
									<td></td>
									<td>Email</td>
									<td><input name="email" type="text"></td>
								</tr>
								<tr>
									<td colspan="3" style="text-align: center;">
										<button class="btn btn-primary" type="submit">Submit</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div class="card-footer text-muted">
						<a href="<%=request.getContextPath()%>">Back to Home page</a>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
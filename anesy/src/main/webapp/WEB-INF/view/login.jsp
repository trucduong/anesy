<%@page import="com.green.util.SpringContextUtil"%>
<%@page import="com.green.config.MessageBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>


<link href="<%=request.getContextPath()%>/resources/main/image/Logo.jpg"
	rel="icon" type="image/jpg">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light navbar-laravel">
	<div class="container">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="<%=request.getContextPath()%>/regis">Bạn có tài khoản
						Anesy chưa ?</a></li>
			</ul>

		</div>
	</div>
	</nav>

	<div class="login-form">
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-5">
				<form action="<%=request.getContextPath()%>/login" method="post">
					<div class="card">
						<div class="card-header" style="text-align: center;">Login</div>
						<div class="card-body">
							<div class="form-group row">
								<label for="email_address"
									class="col-md-4 col-form-label text-md-right">E-Mail </label>
								<div class="col-md-6">
									<input type="text" id="email_address" class="form-control"
										name="email" required>
								</div>
							</div>
							<div class="form-group row">
								<label for="password"
									class="col-md-4 col-form-label text-md-right">Password</label>
								<div class="col-md-6">
									<input type="password" id="password" class="form-control"
										name="password" required>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-10 offset-md-2">
									<a href="<%=request.getContextPath()%>/resetpass"
									class="btn btn-link">Forgot Your Password?</a>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6 offset-md-4">
									<button style="width:150px" type="submit" class="btn btn-primary">Login</button>
								</div>
							</div>
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%
		MessageBox msgBox = SpringContextUtil.getBean(MessageBox.class);
		if (msgBox.hasMessage()) {
	%>
	<div class="modal fade" id="msgBoxModal" tabindex="-1" role="dialog"
		aria-labelledby="msgBoxModalTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<%=msgBox.getMessage()%>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<%
		msgBox.clear();
		}
	%>

	<jsp:include page="../component/common-js.jsp"></jsp:include>

</body>
</html>
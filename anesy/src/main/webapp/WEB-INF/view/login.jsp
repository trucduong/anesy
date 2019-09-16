<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>


<link href="<%=request.getContextPath() %>/resources/main/image/Logo.jpg"" rel="icon" type="image/jpg">
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
				<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>
			</ul>

		</div>
	</div>
	</nav>

	<main class="login-form">
	<div class="cotainer">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">Login</div>
					<div class="card-body">
						<form action="<%=request.getContextPath()%>/login" method="post">
							<p>${message}</p>
							<div class="form-group row">
								<label for="email_address"
									class="col-md-4 col-form-label text-md-right">E-Mail
									</label>
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
								<div class="col-md-6 offset-md-4">
									<div class="checkbox">
										<label> <input type="checkbox" name="remember">
											Remember Me
										</label>
									</div>
								</div>
							</div>

							<div class="col-md-6 offset-md-4">
								<button type="submit" class="btn btn-primary">Login</button>
								<a href="#" class="btn btn-link"> Forgot Your Password? </a>
							</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>

	</main>
</body>
</html>
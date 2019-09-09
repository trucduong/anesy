<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 50%;
}

td, th {
	text-align: left;
	padding: 10px;
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
	<h2>Register an account</h2>
	<div class="container">
		<div>
			<form action="<%=request.getContextPath()%>/regis" method="post">
				<table align="center">
					<tr>
						<td>Email</td>
						<td><input name="email" type="text"></td>
					</tr>

					<tr>
						<td>Full </td>
						<td><input name="fullName" type="text"></td>
					</tr>
				</table>
				<button style="float: right;" type="submit"></button>
			</form>
		</div>
		<a href="<%=request.getContextPath()%>">Back to Home page</a>
	</div>

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
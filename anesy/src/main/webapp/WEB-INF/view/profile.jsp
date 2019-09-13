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
}

</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="../component/header.jsp"></jsp:include>
	<div class="container" style="min-height: 622px">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8" style="padding: 2.75rem;">
				<div class="card text-center">
					<div class="card-header">Your Account</div>
					<div class="card-body">
						<form action="<%=request.getContextPath()%>/profile" method="post">
							<table align="center">
								<tr>
									<td>Email</td>
									<td><input name="email" value="${_profile.email}"
										type="text"></td>
								</tr>
								<tr>
									<td>Your Name</td>
									<td><input name="fullName" value="${_profile.fullName}"
										type="text"></td>
								</tr>
								<tr>
									<td>Phone Number</td>
									<td><input name="phone" value="${_profile.phone}"
										type="text"></td>
								</tr>
								<tr>
									<td>Birth Date</td>
									<td><input name="birthDate" value="${_profile.birthDate}"
										type="date"></td>
								</tr>
								<tr>
									<td>User Type</td>
									<td><select name="userType">
											<option value="0" ${_profile.gender eq '0' ? 'selected': ''}>Học viên</option>
											<option value="1" ${_profile.gender eq '1' ? 'selected': ''}>Giáo viên</option>
											<option value="2" ${_profile.gender eq '2' ? 'selected': ''}>Trung tâm</option>
									</select></td>
								</tr>
								<tr>
									<td>Gender</td>
									<td><select name="gender">
											<option value="M" ${_profile.gender eq 'M' ? 'selected': ''}>Male</option>
											<option value="F" ${_profile.gender eq 'F' ? 'selected': ''}>FeMale</option>
									</select></td>
								</tr>
								<tr>
									<td>Address</td>
									<td><textarea name="address" rows="3">${_profile.address}</textarea></td>
								</tr>
								<tr>
									<td>Certificates</td>
									<td><textarea name="certificates" rows="3">${_profile.certificates}</textarea></td>
								</tr>
								<tr>
									<td colspan="2" style="text-align: center;">
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
			<div class="col-md-2"></div>
		</div>
	</div>

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
<%@ page import="com.green.entity.Profile"%>
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

	<%
		Profile profile = (Profile) request.getAttribute("_profile");
	%>

	<jsp:include page="../../component/header.jsp"></jsp:include>

	<div class="container page">
		<div class="row">
			<div class="col-md-4">




				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text left" id="inputGroupFileAddon01">Upload</span>
					</div>
					<div class="custom-file">
						<input type="file" class="custom-file-input" id="inputGroupFile01"
							aria-describedby="inputGroupFileAddon01"> <label
							class="custom-file-label" for="inputGroupFile01">Choose
							file</label>
					</div>
				</div>


				<jsp:include page="../../component/profilelistgroup.jsp"></jsp:include>
			</div>
			<div class="col-md-7">
				<div class="card">
					<h5 class="card-header">Thông Tin Cá Nhân</h5>
					<div class="card-body">

						<form action="<%=request.getContextPath()%>/profile/info"
							method="post">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Họ
										và tên</span>
								</div>
								<input name="name" type="text" class="form-control"
									value="<%=profile.getFullName()%>"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Số
										điện thoại</span>
								</div>
								<input name="phone" type="text" class="form-control"
									value="<%=profile.getPhone()%>"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Email</span>
								</div>
								<input name="email" type="text" class="form-control"
									value="<%=profile.getEmail()%>"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="inputGroup-sizing-default">Ngày
										sinh </span>
								</div>
								<input id="checkin" name="birthday" type="date"
									value="<%=profile.getBirthDate()%>" class="form-control"
									aria-label="Sizing example input"
									aria-describedby="inputGroup-sizing-default">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<label class="input-group-text" for="inputGroupSelect01">Giới
										tính</label>
								</div>
								<select name="gender" class="custom-select"
									value="<%=profile.getGender()%>" id="inputGroupSelect01">
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
								<textarea name="address" type="text" class="form-control"
									id="email" value="<%=profile.getAddress()%>" required=""
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

	<jsp:include page="../../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../../component/common-js.jsp"></jsp:include>
</body>
</html>


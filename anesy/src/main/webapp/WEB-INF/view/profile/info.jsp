<%@page import="com.green.util.SpringContextUtil"%>
<%@page import="com.green.config.AuthContext"%>
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
	<%
		AuthContext authContext = SpringContextUtil.getBean(AuthContext.class);
	%>

	<jsp:include page="../../component/header.jsp"></jsp:include>

	<div class="container page">
		<div class="row">
			<div class="col-md-4">
				<jsp:include page="../../component/profilelistgroup.jsp"></jsp:include>
			</div>
			<div class="col-md-8">
				<div class="card">
					<h5 class="card-header">Thông Tin Cá Nhân</h5>
					<div class="card-body">

						<form method="post">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" >Họ và tên</span>
								</div>
								<input name="fullName" type="text" class="form-control" 
									value="${_profile.fullName}">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">Số điện thoại</span>
								</div>
								<input name="phone" type="text" class="form-control" value="${ _profile.phone}">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" >Email</span>
								</div>
								<input name="email" type="text" class="form-control" value="${ _profile.email}">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" >Ngày sinh </span>
								</div>
								<input name="birthDate" type="date" value="${ _profile.birthDate}" class="form-control">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<label class="input-group-text" >Giới tính</label>
								</div>
								<select name="gender" class="custom-select" value="${ _profile.gender}" >
									<option selected>Vui lòng chọn</option>
									<option value="1">Nam</option>
									<option value="2">Nữ</option>
								</select>
							</div>

							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">Địa Chỉ</span>
								</div>
								<textarea name="address" type="text" class="form-control">${_profile.address}</textarea>
							</div>
							<%if(authContext.getUserType() ==2 && authContext.getUserType() ==3) %>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">Chủ đề giảng dạy</span>
								</div>
								<textarea name="specialize" type="text" class="form-control">${_profile.specialize}</textarea>
							</div>
							
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">Tiểu sử</span>
								</div>
								<textarea name="description" type="text" class="form-control">${_profile.description}</textarea>
							</div>


							<div id="success"></div>
							<button type="submit" class="btn btn-primary">Cập Nhật</button>
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


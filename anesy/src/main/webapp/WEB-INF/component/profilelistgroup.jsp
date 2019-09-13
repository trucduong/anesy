<%@ page import="com.green.entity.Profile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String currentPage = request.getAttribute("javax.servlet.forward.request_uri").toString()
			.substring(request.getContextPath().length());
%>
<%
	Profile profile = (Profile) request.getAttribute("_info");
%>
<div class="card">
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
		
	</div>

</div>
<div class="list-group">
	<a href="<%=request.getContextPath()%>/profile/info"
		class="list-group-item list-group-item-action <%=currentPage.equals("/profile/info") ? "active" : ""%>">Thông
		Tin Cá Nhân</a> <a href="<%=request.getContextPath()%>/profile/password"
		class="list-group-item list-group-item-action <%=currentPage.equals("/profile/password") ? "active" : ""%>">Tài
		Khoản </a> <a href="<%=request.getContextPath()%>/profile/history"
		class="list-group-item list-group-item-action <%=currentPage.equals("/profile/history") ? "active" : ""%>">Lịch
		Sử Học Tập</a> <a href="<%=request.getContextPath()%>/profile/certificate"
		class="list-group-item list-group-item-action <%=currentPage.equals("/profile/certificate") ? "active" : ""%>">Chứng
		Chỉ</a>
</div>
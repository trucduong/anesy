<%@page import="com.green.util.SpringContextUtil"%>
<%@page import="com.green.config.AuthContext"%>
<%@ page import="com.green.entity.Profile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String currentPage = request.getAttribute("javax.servlet.forward.request_uri").toString()
			.substring(request.getContextPath().length());
%>
<%
	AuthContext authContext = SpringContextUtil.getBean(AuthContext.class);
	Profile profile = authContext.getProfile();
%>

<div class="mb-2" style="position: inherit;">
	<div class="image-box" >
		<input id="_profileImgFile" type="file" class="custom-file-input" onchange="doUpload('profile', '_profile', {targetId: <%=authContext.getAccountId() %>});">
		<img id="_profileImg" alt="Avatar" src="<%=request.getContextPath()%>/image/profile/<%=authContext.getAccountId() %>">
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
		<a href="<%=request.getContextPath()%>/profile/my-course"
		class="list-group-item list-group-item-action <%=currentPage.equals("/profile/my-course") ? "active" : ""%>">Khóa Học Của Tôi</a>
</div>

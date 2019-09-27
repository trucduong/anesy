<%@page import="com.green.config.AuthContext"%>
<%@page import="com.green.config.MessageBox"%>
<%@page import="com.green.util.SpringContextUtil"%>
<%@page import="com.green.entity.CourseCategory"%>
<%@page import="com.green.config.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "anesy" uri="/WEB-INF/anesy.tld"%>

<%
	AuthContext authContext = SpringContextUtil.getBean(AuthContext.class);
%>

<%
Alert alert = SpringContextUtil.getBean(Alert.class);
if (!alert.getMessages().isEmpty()) {
%>
	<div class="container" style="padding-top: 10px">
<%
	for (int i = 0; i < alert.getMessages().size(); i++) {
		String message = alert.getMessages().get(i);
		String type = alert.getTypes().get(i).name();
%>

	<div class="alert alert-<%=type %> alert-dismissible fade show" role="alert"><%=message %>
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    		<span aria-hidden="true">&times;</span>
  		</button>
	</div>
<%
	}
%>
</div>
<%
alert.clear();
}
%>

<%
	MessageBox msgBox = SpringContextUtil.getBean(MessageBox.class);
	if (msgBox.hasMessage()) {
%>
<div class="modal fade" id="msgBoxModal" tabindex="-1" role="dialog" aria-labelledby="msgBoxModalTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <%=msgBox.getMessage() %>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<%
msgBox.clear();
	}
%>

<header>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="<%= request.getContextPath()%>">ANESY</a>
       <anesy:category-dropdown></anesy:category-dropdown>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      
      <div class="collapse navbar-collapse" id="navbarResponsive">
      
        <ul class="navbar-nav ml-auto">
       	<li class="nav-item">
        	<a class="nav-link" href="">
        	<i class="material-icons">add_shopping_cart</i>
			</a>
		</li>
          <span aria-label="1 item" class="badge" style="color: red;margin-left: -18px;font-size: 15px;">1</span>
        
          <li class="nav-item">
            <a class="nav-link" href="about.html">Khóa học của tôi</a>
          </li>
          
          
         
         
          <%if(authContext.isAuthenticated()) {%>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
             <img alt=" " src="#"> <%=authContext.getFullName() %>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="<%= request.getContextPath()%>/profile/info">Thông Tin Tài Khoản</a>
              <a class="dropdown-item" href="<%= request.getContextPath()%>/profile/password">Đổi Mật Khẩu</a>
              <a class="dropdown-item" href="<%= request.getContextPath()%>/profile/history">Lịch Sử Học Tập</a>
              <a class="dropdown-item" href="<%= request.getContextPath()%>/profile/certificate">Chứng Chỉ</a>
              <%if(authContext.getUserType()!=0) {%>
              <a class="dropdown-item" href="<%= request.getContextPath()%>/profile/certificate">Quản lý khóa học</a>
              <%} %>
              <a class="dropdown-item" href="<%=request.getContextPath()%>/login">Logout</a>
            </div>
          </li>
          <%}else{ %>
           <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/login">Đăng Nhập</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/regis">Đăng Ký</a>
          </li>
          <% }%>
          
        </ul>
        
      </div>
      
      
    </div>
  </nav>
</header>
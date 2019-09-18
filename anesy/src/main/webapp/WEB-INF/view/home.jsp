<%@page import="com.green.model.CourseFilter"%>
<%@page import="com.green.entity.CourseCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.green.util.SpringContextUtil"%>
<%@page import="com.green.config.AuthContext"%>
<%@ page import="com.green.entity.Profile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8" isELIgnored="false"%>

    
<%@ taglib prefix = "anesy" uri="/WEB-INF/anesy.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to anesy</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>

</head>
<body>
	<%
		Profile profile = (Profile) request.getAttribute("_profile");
	%>
	<%
		AuthContext authContext = SpringContextUtil.getBean(AuthContext.class);
	%>
	<jsp:include page="../component/header.jsp"></jsp:include>

	<div class="row hinh" >
		<div class="col-md-6">
		<div style="margin-top: 200px; color: red">
		<div>
		<h2><b>haha</b></h2>
		<p>Anywhere, anytime. Enjoy risk-free with our 30-day, money-back guarantee.</p>
		</div>
		<div class="input-group" >
			<input type="text" class="form-control"
				placeholder="Tìm kiếm khóa học" role="combobox"> <span
				class="input-group-btn">
				<button class="btn btn-secondary" type="button">Tìm kiếm</button>
			</span>
		</div>
		</div>	
		</div>
	</div>
	<div class="container page">

		<div class="row">
		Slogan
		</div>

		<div class="row">
		<%
		List<CourseCategory> categories = (List<CourseCategory>) request.getAttribute("_categories");
		if (categories.size() > 0) {
		%>
			<div class="col-md-12">
				<div class="bd-example bd-example-tabs">
				  <nav>
				    <div class="nav nav-tabs" id="nav-tab" role="tablist">
				    <%
				    	for(int i=0; i < categories.size(); i++) {
				    		CourseCategory category = categories.get(i);
				    %>
				    	<a class="nav-item nav-link <%=i==0?"active show":"" %>" id="nav-cat-<%=category.getId() %>-tab" data-toggle="tab" href="#nav-cat-<%=category.getId() %>" role="tab" aria-controls="nav-cat-<%=category.getId() %>" aria-selected="true"><%=category.getName() %></a>
				    <% } %>
				    </div>
				  </nav>
				  <div class="tab-content" id="nav-tabContent" style="margin-top: 10px;">
				  	<%
				    	for(int i=0; i < categories.size(); i++) {
				    		CourseCategory category = categories.get(i);
				    		CourseFilter filter = new CourseFilter();
				    		filter.setCategory(category.getId());
				    		pageContext.setAttribute("_courseFilter", filter);
				    %>
			    	<div class="tab-pane fade <%=i==0?"active show":"" %>" id="nav-cat-<%=category.getId() %>" role="tabpanel" aria-labelledby="nav-cat-<%=category.getId() %>-tab">
				      <anesy:course-list filter="${_courseFilter}" limit="9"></anesy:course-list>
				    </div>
				    <% } %>
				  </div>
				</div>
			</div>
		<% } %>
		</div>
		
		<div class="row">
		Top categories
		</div>
		
		
		<div class="row">
			<h2>Bình luận của học sinh</h2>
		</div>
		<div class="row justify-content-center">
			<div class="col-4">
				<div class="card comment-card">
				  	<div class="card-body">
					    <div class=comment-card-info>
					    	<div>
					    		<img alt="" src="<%=request.getContextPath()%>/resources/image/hoc-tap-2.jpg" width="64" height="64">
					    	</div>
					    	<div class=comment-card-name style="padding-left: 15px;">
					    		<div>Trọng Anh</div>
					    	</div>					    	
					    </div>
					    <p class="card-text" >Trung tâm hay quá tui muốn .................................................................</p>
				  </div>
				</div>
			</div>
			
			<div class="col-4">
				<div class="card comment-card">
				  	<div class="card-body">
					    <div class=comment-card-info>
					    	<div>
					    		<img alt="" src="<%=request.getContextPath()%>/resources/image/hoc-tap-2.jpg" width="64" height="64">
					    	</div>
					    	<div class=comment-card-name style="padding-left: 15px;">
					    		<div>Trọng Anh</div>
					    	</div>					    	
					    </div>
					    <p class="card-text" >Trung tâm hay quá tui muốn .................................................................</p>
				  </div>
				</div>
			</div>
			
			<div class="col-4">
				<div class="card comment-card">
				  	<div class="card-body">
					    <div class=comment-card-info>
					    	<div>
					    		<img alt="" src="<%=request.getContextPath()%>/resources/image/hoc-tap-2.jpg" width="64" height="64">
					    	</div>
					    	<div class=comment-card-name style="padding-left: 15px;">
					    		<div>Trọng Anh</div>
					    	</div>					    	
					    </div>
					    <p class="card-text" >Trung tâm hay quá tui muốn .................................................................</p>
				  </div>
				</div>
			</div>
		</div>
		
		<div class="row">
		partners
		</div>
		
		<div class="row" style="height: 50px"></div>
		
		<%if(authContext.getUserType()!=2 && authContext.getUserType()!=2 ){ %>

		<div class="row justify-content-center">
			<div class="col-5">
				<div class="card text-center">
				  	<div class="card-body">
					    <h5 class="card-title"  >Trở Thành Giáo Viên</h5>
					    <p class="card-text" > Dạy những gì bạn yêu thích thông qua công cụ của Anesy</p>
					    
					    <a href="#" class="btn btn-primary" >Đăng Ký </a>
				  </div>
				</div>
			</div>
			
			<div class="col-5">
				<div class="card text-center">
				  	<div class="card-body">
				    <h5 class="card-title" >Trở Thành Trung Tâm</h5>
				    <p class="card-text" >Trở thành trung tâm online thông qua công cụ của Anesy</p>
				    <a href="#" class="btn btn-primary">Đăng Ký </a>
			  </div>
			</div>
			
			
			</div>
		</div>
		
		<%} %>
		
		<div class="row" style="height: 50px"></div>
	</div>
	
	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
<%@ page import="com.green.entity.Profile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>

</head>
<body>
	<%
		Profile profile = (Profile) request.getAttribute("_profile");
	%> 
	<jsp:include page="../component/header.jsp"></jsp:include>

	<div class="container page">
		<div class = "row">
		<div class="col-md-3">
	        <div class="list-group">
	          <a href="index.html" class="list-group-item">Home</a>
	          <a href="about.html" class="list-group-item">About</a>
	          <a href="services.html" class="list-group-item">Services</a>
	          <a href="contact.html" class="list-group-item">Contact</a>
	          <a href="portfolio-1-col.html" class="list-group-item">1 Column Portfolio</a>
	          <a href="portfolio-2-col.html" class="list-group-item">2 Column Portfolio</a>
	          <a href="portfolio-3-col.html" class="list-group-item">3 Column Portfolio</a>
	          <a href="portfolio-4-col.html" class="list-group-item">4 Column Portfolio</a>
	          <a href="portfolio-item.html" class="list-group-item">Single Portfolio Item</a>
	          <a href="blog-home-1.html" class="list-group-item">Blog Home 1</a>
	          <a href="blog-home-2.html" class="list-group-item">Blog Home 2</a>
	          <a href="blog-post.html" class="list-group-item">Blog Post</a>
	          <a href="full-width.html" class="list-group-item">Full Width Page</a>
	          <a href="sidebar.html" class="list-group-item active">Sidebar Page</a>
	          <a href="faq.html" class="list-group-item">FAQ</a>
	          <a href="404.html" class="list-group-item">404</a>
	          <a href="pricing.html" class="list-group-item">Pricing Table</a>
	        </div>
      </div>
      <div class="col-md-6">
	      <div class="card-body">
	            <div class="input-group">
	              <input type="text" class="form-control" placeholder="Tìm kiếm khóa học"  role="combobox">
	              <span class="input-group-btn">
	                <button class="btn btn-secondary" type="button">Tìm kiếm</button>
	              </span>
	        </div>
	       </div>
		</div>
		<div class="col-md-3">
	      â
		</div>
	</div>
	</div>
	</div>
	
	
	
	

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
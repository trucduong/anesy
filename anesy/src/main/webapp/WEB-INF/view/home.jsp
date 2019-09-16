<%@page import="com.green.util.SpringContextUtil"%>
<%@page import="com.green.config.AuthContext"%>
<%@ page import="com.green.entity.Profile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8" isELIgnored="false"%>
=======
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib prefix = "anesy" uri="/WEB-INF/anesy.tld"%>

>>>>>>> refs/remotes/origin/dev
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

<<<<<<< HEAD
	<div class="row hinh" >
		<div class="col-md-6">
		<div style="margin-top: 200px; color: red;">
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

		<div class="row category">
			<div class="col-md-12">
			<div class="title">
			<h2><b>Khóa Học</b></h2>
			</div>
				<div class="btn-group btn-group-toggle" data-toggle="buttons">
					<label class="btn btn-secondary active"> <input
						type="radio" name="options" id="option1" autocomplete="off"
						checked> Active
					</label> <label class="btn btn-secondary"> <input type="radio"
						name="options" id="option2" autocomplete="off"> Radio
					</label> <label class="btn btn-secondary"> <input type="radio"
						name="options" id="option3" autocomplete="off"> Radio
					</label>
					<label class="btn btn-secondary active"> <input
						type="radio" name="options" id="option1" autocomplete="off"
						checked> Active
					</label> <label class="btn btn-secondary"> <input type="radio"
						name="options" id="option2" autocomplete="off"> Radio
					</label> <label class="btn btn-secondary"> <input type="radio"
						name="options" id="option3" autocomplete="off"> Radio
					</label>
				</div>
				
				<div class="box">
				<div class="col">
				<div class="course-item">
				<figure>
					<a href="">
					<img onerror="" alt="" src="">
					</a>
				</figure>
				<div course-item-decription>
				
				</div>
				</div>
				</div> 
				
				
				<div class="col">
				<div class="course-item">
				<figure>
					<a href="">
					<img onerror="" alt="" src="">
					</a>
				</figure>
				<div course-item-decription>
				
				</div>
				</div>
				</div> 
				
				<div class="col">
				<div class="course-item">
				<figure>
					<a href="">
					<img onerror="" alt="" src="">
					</a>
				</figure>
				<div course-item-decription>
				
				</div>
				</div>
				</div>
				
				<div class="col">
				<div class="course-item">
				<figure>
					<a href="">
					<img onerror="" alt="" src="">
					</a>
				</figure>
				<div course-item-decription>
				
				</div>
				</div>
				</div>
				
				<div class="col">
				<div class="course-item">
				<figure>
					<a href="">
					<img onerror="" alt="" src="">
					</a>
				</figure>
				<div course-item-decription>
				
				</div>
				</div>
				</div>
				
				<div class="col">
				<div class="course-item">
				<figure>
					<a href="">
					<img onerror="" alt="" src="">
					</a>
				</figure>
				<div course-item-decription>
				
				</div>
				</div>
				</div>
				
				
				
				
				</div>
			</div>
=======
<div class="container page">
	<div class="row">
		<div class="col-md-12">
			<anesy:course-list></anesy:course-list>
		</div>
	</div>
	
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
>>>>>>> refs/remotes/origin/dev
		</div>
		
	</div>
<<<<<<< HEAD





=======
</div>
	
	
	
	
>>>>>>> refs/remotes/origin/dev

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
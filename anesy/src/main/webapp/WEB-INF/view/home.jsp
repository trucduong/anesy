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
<title>Insert title here</title>

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
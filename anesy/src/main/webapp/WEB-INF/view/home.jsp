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
<title>Learn IT, Make IT - ANESY</title>

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
		<div style="margin-top: 200px; color: red; ">
		<div>
		<h2><b>haha</b></h2>
		<p>Anywhere, anytime. Enjoy risk-free with our 30-day, money-back guarantee.</p>
		</div>
		<form action="<%=request.getContextPath()%>/course" method="get">
		<div class="input-group" >
			<input name="filter" type="text" class="form-control"
				placeholder="Tìm kiếm khóa học" role="combobox"> <span
				class="input-group-btn">
				<button class="btn btn-secondary" type="submit">Tìm kiếm</button>
			</span>
		</div>
		</form>
		</div>	
		</div>
	</div>
	

		<div class="row slogan">
			<div class="col-sm-4 text-content text-center ">
	      		<b>100.000 khóa học trực tuyến</b>
	      		<div>
	      		  Khám phá nhiều chủ đề mới
	   			</div>
	   		</div>
	    	<div class="col-sm-4 text-content text-center ">
	      		<b>Hướng dẫn chuyên môn</b>
	      		<div>
	      		  Tìm người hướng dẫn phù hợp với bạn
	   			</div>
	     	</div>
	    	<div class="col-sm-4 text-content text-center ">
	      		<b>Truy cập trọn đời</b>
	      		<div>
	      		  Học theo lịch trình của bạn
	   			</div>
	    	</div>
		</div>
	<div class="container page">
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
		
		
		<div><jsp:include page="../component/top-category.jsp"></jsp:include></div>
		
		
		<div class="row comment-stu">
			<h2>Bình luận của học sinh</h2>
		</div>
		<div class="row justify-content-center">
			<div class="col-4">
				<div class="card comment-card">
				  	<div class="card-body">
					    <div class=comment-card-info>
					    	<div>
					    		<img alt="" src="<%=request.getContextPath()%>/resources/image/avatar-comment-image/hinh1.jpg" width="64" height="64">
					    	</div>
					    	<div class=comment-card-name style="padding-left: 15px;">
					    		<div>Trân Bội Huân</div>
					    	</div>					    	
					    </div>
					    <p class="card-text" >Tôi đã tham gia khóa học, các thầy cô đã chia sẽ kiến thức rất thực tế, hiện tại, tay nghề tôi vững vàng hơn sau mỗi ngày học, nếu bạn đang cần môi trường học chuyên nghiệp, tôi khuyên bạn nên đăng ký tham gia</p>
				  </div>
				</div>
			</div>
			
			<div class="col-4">
				<div class="card comment-card">
				  	<div class="card-body">
					    <div class=comment-card-info>
					    	<div>
					    		<img alt="" src="<%=request.getContextPath()%>/resources/image/avatar-comment-image/hinh2.jpg" width="64" height="64">
					    	</div>
					    	<div class=comment-card-name style="padding-left: 15px;">
					    		<div>Lê Thị Ý Lan</div>
					    	</div>					    	
					    </div>
					    <p class="card-text" >Thông qua người bạn giới thiệu tôi đã tham gia khóa học Tiếng Anh tại Anesy, thật sự các thầy cô đã chia sẻ kiến thức rất hay, đã giúp tôi học tập hiệu quả tốt hơn trước đây rất nhiều.</p>
				  </div>
				</div>
			</div>
			
			<div class="col-4">
				<div class="card comment-card">
				  	<div class="card-body">
					    <div class=comment-card-info>
					    	<div>
					    		<img alt="" src="<%=request.getContextPath()%>/resources/image/avatar-comment-image/hinh3.jpg" width="64" height="64">
					    	</div>
					    	<div class=comment-card-name style="padding-left: 15px;">
					    		<div>Nguyễn Song Gia Bảo</div>
					    	</div>					    	
					    </div>
					    <p class="card-text" >Mình thích nhất là được thầy hỗ trợ mình nếu không hiểu gì có thể liên hệ trực tiếp với thầy cô, giờ mình tự tin hành nghề Thiết Kế, thu nhập mỗi tháng từ việc làm thêm cũng hơn 10 Triệu.</p>
				  </div>
				</div>
			</div>
		</div>
		
		<div class="row partner">
		
		<div class="logo-partner">
			<img alt="booking" src="<%=request.getContextPath()%>/resources/image/logo-partner-image/booking-logo.svg" width="156" height="26"">
		</div>
		<div class="logo-partner">
			<img alt="adidas" src="<%=request.getContextPath()%>/resources/image/logo-partner-image/adidas-logo.svg" width="156" height="26"">
		</div>
		<div class="logo-partner">
			<img alt="eventbrite" src="<%=request.getContextPath()%>/resources/image/logo-partner-image/eventbrite-logo.svg" width="156" height="26"">
		</div>
		<div class="logo-partner">
			<img alt="mercedes" src="<%=request.getContextPath()%>/resources/image/logo-partner-image/mercedes-logo.svg" width="156" height="26"">
		</div>
		<div class="logo-partner">
			<img alt="pinterest" src="<%=request.getContextPath()%>/resources/image/logo-partner-image/pinterest-logo.svg" width="156" height="26"">
		</div>
		<div class="logo-partner">
			<img alt="volkswagen" src="<%=request.getContextPath()%>/resources/image/logo-partner-image/volkswagen-logo.svg" width="156" height="26"">
		</div>
		</div>
		
		<div class="row" style="height: 50px"></div>
		
		<%if(authContext.getUserType()!=2 && authContext.getUserType()!=2 ){ %>

		<div class="row justify-content-center">
			<div class="col-5">
				<div class="card text-center">
				  	<div class="card-body">
					    <h5 class="card-title"  >Trở Thành Giáo Viên</h5>
					    <p class="card-text" > Dạy những gì bạn yêu thích thông qua công cụ của Anesy</p>
					    
					    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">Đăng ký</button>
				  </div>
				</div>
			</div>
			
			<div class="col-5">
				<div class="card text-center">
				  	<div class="card-body">
				    <h5 class="card-title" >Trở Thành Trung Tâm Giảng Viên</h5>
				    <p class="card-text" >Trở thành trung tâm giảng viên thông qua công cụ của Anesy</p>
				    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">Đăng ký</button>
				    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Đăng ký trở thành giảng viên</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="<%=request.getContextPath()%>/regis/teacher" method="post">
        <input type="hidden" name="id" value="<%=authContext.getAccountId()%>">
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Họ và tên:</label>
            <input name="name" type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Số điện thoại:</label>
            <input name="phone" type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Chủ đề giảng dạy của bạn là gì ?</label>
            <input name="specialize" type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Tiểu sử của bạn (Mô tả chi tiết về bản thân)</label>
            <textarea name="description" type="text" class="form-control"></textarea>
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Bạn đã có kinh nghiệm tạo video khóa học chưa ?</label><br>
              <input type="radio" name="experience" value="begin"> Mới bắt đầu<br>
  			  <input type="radio" name="experience" value="little">Một chút<br>
 			  <input type="radio" name="experience" value="high">Đã có kinh nghiệm<br>
 			  <input type="radio" name="experience" value="best">Đã có video và sẵn sàng tải lên Anesy<br>   
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Đăng ký</button>
      </div>
      </form>
    </div>
  </div>
</div>
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
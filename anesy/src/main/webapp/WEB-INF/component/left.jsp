<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
String currentPage = request.getAttribute("javax.servlet.forward.request_uri").toString()
						.substring(request.getContextPath().length());
%>
	
<div style="padding-top: 20px;">
<div class="list-group">
  <a href="<%=request.getContextPath()%>/admin/course-category" class="list-group-item list-group-item-action <%=currentPage.equals("/admin/course-category") ? "active" : ""%>">Category</a>
  <a href="<%=request.getContextPath()%>/admin/course" class="list-group-item list-group-item-action <%=currentPage.equals("/admin/course") ? "active" : ""%>">Khóa học</a>
  <a href="<%=request.getContextPath()%>/admin/subjects" class="list-group-item list-group-item-action <%=currentPage.equals("/admin/subjects") ? "active" : ""%>">Môn học</a>
  <a href="<%=request.getContextPath()%>/admin/lesson" class="list-group-item list-group-item-action <%=currentPage.equals("/admin/lesson") ? "active" : ""%>">Bài giảng</a>
  <a href="<%=request.getContextPath()%>/admin/exercise" class="list-group-item list-group-item-action <%=currentPage.equals("/admin/exercise") ? "active" : ""%>">Bài tập</a>
  <a href="<%=request.getContextPath()%>/" class="list-group-item list-group-item-action">Về trang chủ</a>
</div>
</div>
<%@page import="com.green.entity.Lesson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý bài giảng</title>

<%-- import css files --%>
<jsp:include page="../component/common-css.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="../component/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-3"><jsp:include page="../component/left.jsp"></jsp:include></div>
			<div class="col-md-6">

				<h1>Tên môn học</h1>

				<div style="margin-top: 20px">
					<a href="<%=request.getContextPath()%>/detail">Thêm bài giảng</a>
				</div>
				<%
					List<Lesson> lessonList = (List<Lesson>) request.getAttribute("lesson_list");
				%>
				<table border="1" cellspacing="0">
					<tr>
						<th>Bài giảng</th>
						<th>Người đăng</th>
						<th>Ngày đăng</th>
						<th>Chỉnh sửa</th>
					</tr>
					<%
						for (Lesson lesson : lessonList) {
					%>
					<tr>
						<td><%=lesson.getName()%></td>
						<td><%=lesson.getAuthor()%></td>
						<td><%=lesson.getCreatedAt()%></td>
						<td>
							<!-- Cần chỉnh sửa lại -->
							<form action="<%=request.getContextPath()%>/detail" method="get">
								<input type="hidden" name="id" value="<%=lesson.getId()%>">
								<input type="hidden" name="action" value="Cập nhật">
								<button type="submit">Update</button>
							</form>
							<form action="<%=request.getContextPath()%>/detail" method="post">
								<input type="hidden" name="id" value="<%=lesson.getId()%>">
								<input type="hidden" name="action" value="Xóa">
								<button type="submit">Delete</button>
							</form>
						</td>
					</tr>
					<%
						}
					%>
				</table>

			</div>
			<div class="col-md-3"><jsp:include
					page="../component/right.jsp"></jsp:include></div>
		</div>
	</div>

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
<%@page import="java.util.List"%>
<%@page import="com.green.entity.Lesson"%>
<%@page import="com.green.entity.Subjects"%>
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
	<jsp:include page="../component/header.jsp"></jsp:include>
	<%
		Lesson lesson = (Lesson) request.getAttribute("_lesson");
		List<Subjects> subjectList = (List<Subjects>) request.getAttribute("_subjectList");
	%>
	<div class="section-header">
		<h2>Product Detail</h2>
	</div>
	<div>
		<form action="<%=request.getContextPath()%>/product/detail"
			method="post">
			<input type="hidden" name="action" value="${action}"> <input
				type="hidden" name="id" value="${_lesson.id}">
			<table>
				<%
					if ("update".equals(request.getAttribute("action"))) {
				%>
				<tr>
					<td>Code</td>
					<td><input value="${_lesson.id}" disabled="disabled">
					</td>
				</tr>
				<%
					}
				%>
				<tr>
					<td>Name</td>
					<td><input name="name" value="${_lesson.name}"></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea name="description" rows="3">${_lesson.description}</textarea>
					</td>
				</tr>
				<tr>
					<td>Subject</td>
					<td><select name="categoryCode">
							<%
								for (Subjects subject : subjectList) {
							%>
							<option value="<%=subject.getId()%>"
								<%=(lesson.getSubjects().getId() == subject.getId() ? "selected" : "")%>><%=subject.getName()%></option>
							<%
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td>Author</td>
					<td><input name="author" value="${_lesson.author}"></td>
				</tr>
				<tr>
					<td>Created At</td>
					<td><input name="createdAt" value="${_lesson.createdAt}"
						type="date"></td>
				</tr>
				<tr>
					<td>Sequence</td>
					<td><input name="seq" value="${_lesson.seq}"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button type="submit">Submit</button>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:include page="../component/footer.jsp"></jsp:include>

	<%-- import js files --%>
	<jsp:include page="../component/common-js.jsp"></jsp:include>
</body>
</html>
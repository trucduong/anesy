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

	<div class="page-container">
		<div class="row">
			<div class="col-md-3"><jsp:include page="../component/left.jsp"></jsp:include></div>
			<div class="col-md-6">

				<%-- input your content here --%>
				<form method="post" modelAtrribute="lesson">
					<input type="hidden" name="action" value="CREATE"
							action="/lesson/create">
					<table>
						<tr>
							<td>Tên bài giảng</td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<td>Miêu tả</td>
							<td><input type="text" name="description"></td>
						</tr>
						<tr>
							<td>Tác giả</td>
							<td><input type="text" name="author"></td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="submit">Tạo bài giảng</button>
							</td>
						</tr>
					</table>
				</form>

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
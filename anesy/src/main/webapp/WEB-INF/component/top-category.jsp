<%@page import="com.green.entity.CourseCategory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.col-sm-6 {
	width: 50%;
}

.top-category {
	margin: 8px 0;
}

.top-category {
	display: inline-block;
	width: 100%;
}

.top-categories-container {
	margin-bottom: 32px;
	padding-left: 16px;
	padding-right: 16px;
}

.top-category-header {
	font-size: 24px;
	font-weight: 600;
	line-height: 1.33em;
	margin-bottom: 5px;
	margin-top: 15px;
}

.panel-default {
	border-color: #ddd;
}

.panel {
	margin-bottom: 21px;
	background-color: #fff;
	border-radius: 2px;
	position: relative;
	border: 1px solid black;
	box-shadow: 3px 3px 3px 1px #888888;
}

.panel-body {
	padding: 5px;
}

.top-category-content {
	display: flex;
	flex-direction: row;
}

.top-category-icon {
	padding-right: 10px;
	padding-left: 10px;
}

.udi {
	vertical-align: -8%;
}

.udi-medium {
	font-size: 32px;
}

.top-category-text {
	height: 32px;
	line-height: 32px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	flex: 1;
	min-width: 1px;
	margin-top: 7px;
}

.ex2:hover, .ex2:active {
	font-size: 150%;
}
</style>

<%
	List<CourseCategory> list = (List<CourseCategory>) request.getAttribute("_categoryList");
	int count = 8;
	if (list.size() < count)
		count = list.size();
%>
<div class="top-categories-container">
	<div class="top-category-header">Top Categories</div>
	<div class="row">
		<%
			for (int i = 0; i < count; i++) {
				CourseCategory category = list.get(i);
		%>
		<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 ex2">
			<div class="top-category panel panel-default">
				<div class="panel-body">
					<a
						href="<%=request.getContextPath()%>/category/<%=category.getId()%>">
						<div class="top-category-content">
							<span class="top-category-icon udi-medium udi"><img alt=""
								src="../anesy/resources/image/<%=category.getName()%>.png"></span>
							<div class="top-category-text"><%=category.getName()%></div>
						</div>
					</a>
				</div>
			</div>
		</div>
		<%
			}
		%>
	</div>
</div>
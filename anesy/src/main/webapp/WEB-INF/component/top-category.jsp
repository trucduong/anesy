<%@page import="com.green.entity.CourseCategory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<style>
.multi-item-carousel { .carousel-inner { > .item{ transition:500msease-in-outleft;
	
}

.active { &.left { left:-33%;
	
}

&
.right {
	left: 33%;
}

}
.next {
	left: 33%;
}

.prev {
	left: -33%;
}

@media all and (transform-3d) , ( -webkit-transform-3d ) { >
	.item { // use your favourite prefixer here transition:500msease-in-outleft;
		transition: 500ms ease-in-out all;
		backface-visibility: visible;
		transform: none !important;
	}
}

}
}
.banner {
	width: 100%;
	height: 450px;
}
</style>


<%
int ITEM_PER_SLIDE = 2;
List<CourseCategory> list = (List<CourseCategory>) request.getAttribute("_categoryList");
int slideCount = list.size()/ITEM_PER_SLIDE;
if (list.size() % ITEM_PER_SLIDE != 0) {
	slideCount++;
}
if(!list.isEmpty()) {
%>

<div class="container-fluid">
	<div class="row banner"
		style="width: 100%; height: 500px; overflow: hidden;">
		<div id="carousel-simple" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
<%
for(int i = 0; i < slideCount; i++) {
%>
				<li data-target="#carousel-simple" data-slide-to="<%=i %>"></li>
<% } %>
			</ol>

			<div class="carousel-inner" role="listbox">
<%
for(int i = 0; i < slideCount; i++) {
%>
				<div class="carousel-item active">
					<div class="row">
<%
	for(int k = 0; k < ITEM_PER_SLIDE; k++) {
		int currentIndex = i * ITEM_PER_SLIDE + k;
		if (currentIndex < list.size()) {
			CourseCategory category = list.get(currentIndex);
%>
						<div class="col-md-6">
							<a
								href="<%=request.getContextPath()%>/category/<%=category.getId()%>"><img
								src="../anesy/resources/image/hoc-tap-2.jpg"
								class="d-block w-100" alt=""></a>
						</div>
					</div>
				</div>
<% 
		}
	}
}
%>
			</div>

			<a class="carousel-control-prev" href="#carouselExampleInterval"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleInterval"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

</div>
<%} %>


<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js">
	$('.multi-item-carousel .item').each(
			function() {
				var next = $(this).next();
				if (!next.length) {
					next = $(this).siblings(':first');
				}
				next.children(':first-child').clone().appendTo($(this));

				if (next.next().length > 0) {
					next.next().children(':first-child').clone().appendTo(
							$(this));
				} else {
					$(this).siblings(':first').children(':first-child').clone()
							.appendTo($(this));
				}
			});
</script>
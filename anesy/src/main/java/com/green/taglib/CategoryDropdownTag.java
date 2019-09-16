package com.green.taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.green.entity.Course;
import com.green.entity.CourseCategory;
import com.green.model.CourseFilter;
import com.green.service.CourseService;
import com.green.util.MyFormater;
import com.green.util.SpringContextUtil;

public class CategoryDropdownTag extends BaseTag {

	private CourseService courseService;
	
	public CategoryDropdownTag() {
		courseService = SpringContextUtil.getBean(CourseService.class);
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		List<CourseCategory> categories = courseService.findCategories();
		
		out.println("<div class='collapse navbar-collapse' id='navbarResponsive'>");
		out.println("<ul class='navbar-nav ml-auto'>");
		out.println("<li class='nav-item dropdown'>");
		out.println("<a class='nav-link dropdown-toggle' href='#' id='navbarDropdownPortfolio' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>Category</a>");
		out.println("<div class='dropdown-menu dropdown-menu-right' aria-labelledby='navbarDropdownPortfolio'>");
		for (CourseCategory courseCategory : categories) {
			renderCategory(courseCategory);
		}
		
		out.println("</div>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</div>");
	}
	
	private void renderCategory(CourseCategory courseCategory) throws IOException {
		JspWriter out = getJspContext().getOut();
		
		out.println("<a class='dropdown-item' href='"
		+getRequest().getContextPath()
		+"/category/" + courseCategory.getId()
		+"'>"+courseCategory.getName()+"</a>");
	}

}

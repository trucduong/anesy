package com.green.taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.green.entity.Course;
import com.green.model.CourseFilter;
import com.green.service.CourseService;
import com.green.util.MyFormater;
import com.green.util.SpringContextUtil;

public class CourseListTag extends BaseTag {
	
	private CourseFilter filter;
	private List<Course> courses;
	
	private int limit = -1;
	
	private CourseService courseService;
	
	public CourseListTag() {
		courseService = SpringContextUtil.getBean(CourseService.class);
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		
		out.println("<div class='card-columns'>");
		
		if (courses == null) {
			courses = courseService.search(filter);
		}
		
		if (limit > 0 && courses.size() > limit) {
			courses = courses.subList(0, limit);
		}
		
		for (Course course : courses) {
			renderCourse(course);
		}
		
		out.println("</div>");
	}
	
	private void renderCourse(Course course) throws IOException {
		JspWriter out = getJspContext().getOut();
		
		out.println("<div class='card'>");
		out.println("<img src='/"+ getRequest().getContextPath() + "/image/course/"+ course.getId() +"' class='card-img-top' alt='"+course.getName()+"'>");
		out.println("<div class='card-body'>");
		out.println("<h5 class='card-title'>"+course.getName()+"</h5>");
		out.println("<p class='card-text'>"+course.getShortdesc()+"</p>");
		out.println("<p class='card-text text-right'><b>"+MyFormater.currency(course.getPrice())+"</b></p>");
		out.println("</div>");
		out.println("</div>");
	}

	public CourseFilter getFilter() {
		return filter;
	}
	
	public void setFilter(CourseFilter filter) {
		this.filter = filter;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
}

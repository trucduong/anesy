package com.green.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.config.AuthContext;
import com.green.config.MessageBox;
import com.green.entity.Course;
import com.green.model.CourseModel;
import com.green.model.Page;
import com.green.service.CourseService;

@Controller
@RequestMapping("/admin/course")
public class AdminCourseController {
	@Autowired
	private AuthContext authContext;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private MessageBox messageBox;
	
	@GetMapping
	public String showListPage(@RequestParam(name="page", required = false) Integer page,
			@RequestParam(name="filter", required = false) String filter,
			Model model) {
		
		if (page == null || page < 1) {
			page = 1;
		}
		
		Page<Course> pageData = courseService.findCourse(filter, page);
		model.addAttribute("_pageData", pageData);
		
		return "/course/admin-course-list";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreatePage(Model model) {
		model.addAttribute("_course", new Course());
		return "/course/admin-course-detail";
	}
	
	@GetMapping("/preview")
	public String showPreview(HttpServletRequest request,Model model) {
	
		Course course = (Course) request.getSession().getAttribute("course_preview");
		model.addAttribute("_comment", new ArrayList<>());
		model.addAttribute("_course", course);
		
		
		return "course/course-review";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleCreate(@ModelAttribute CourseModel courseModel, Model model, HttpServletRequest request) {
		
		Date date = new Date();
		Course course = new Course();
		course.setAvatar(courseModel.getAvatar());
		course.setBenefit(courseModel.getBenefit());
		course.setDescription(courseModel.getDescription());
		course.setInclude(courseModel.getInclude());
		course.setName(courseModel.getName());
		course.setPrice(courseModel.getPrice());
		course.setRequiment(courseModel.getRequiment());
		course.setShortdesc(courseModel.getShortdesc());
		course.setAuthor(authContext.getProfile());
		course.setCreatedAt(date);
		
		if("preview".equals(courseModel.getAction())) {
			model.addAttribute("_course", course);
			request.getSession().setAttribute("course_preview", course);
			return "/course/admin-course-detail";
		}
		
		
		courseService.insert(course);
		return "redirect:/admin/course";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showUpdatePage(@PathVariable("id") int id, Model model) {
		
		Course course = courseService.findById(id);
		if (course == null) {
			messageBox.setMessage("Không tìm thấy course id: " + id);
			return "redirect:/admin/course";
		}
		
		model.addAttribute("_course", course);
		
		return "/course/admin-course-detail";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String handleUpdate(@PathVariable("id") int id,
			@ModelAttribute CourseModel courseModel, Model model, HttpServletRequest request) {
		
		
		Course course = courseService.findById(id);
		if (course == null) {
			messageBox.setMessage("Không tìm thấy course id: " + id);
			return "redirect:/admin/course";
		}

		Date date = new Date();
		course.setAvatar(courseModel.getAvatar());
		course.setBenefit(courseModel.getBenefit());
		course.setDescription(courseModel.getDescription());
		course.setInclude(courseModel.getInclude());
		course.setName(courseModel.getName());
		course.setPrice(courseModel.getPrice());
		course.setRequiment(courseModel.getRequiment());
		course.setShortdesc(courseModel.getShortdesc());
		course.setAuthor(authContext.getProfile());
		
		if("preview".equals(courseModel.getAction())) {
			model.addAttribute("_course", course);
			request.getSession().setAttribute("course_preview", course);
			return "/course/admin-course-detail";
		}
		
		
		courseService.update(course);
		
		return "redirect:/admin/course";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public String handleDelete(@PathVariable("id") int id) {
		courseService.delete(courseService.findById(id));
		return "redirect:/admin/course";
	}
}

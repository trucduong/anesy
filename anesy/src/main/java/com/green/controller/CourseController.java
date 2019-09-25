package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.entity.Course;
import com.green.entity.CourseCategory;
import com.green.entity.CourseComment;
import com.green.model.CourseFilter;
import com.green.service.CourseService;
import com.green.service.ProfileService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping
	public String showCourseList(@RequestParam(name = "filter", required = false) String filter,
			@RequestParam(name = "catId", required = false) Integer catId,
			Model model) {
		
		CourseFilter cFilter = new CourseFilter();
		cFilter.setCategory(catId);
		cFilter.setSearchText(filter);
		List<Course> courses = courseService.search(cFilter);
		List<CourseCategory> category = courseService.findCategories();
	
		model.addAttribute("_categories", category);
		model.addAttribute("_courses", courses);
		return "course/course-list";
	}
	
	@GetMapping("/{id}")
	public String showCourseStyle(@PathVariable(name = "id") int id,Model model) {
		Course course = courseService.findById(id);
		List<CourseComment> commentList = courseService.findAllComments(id);
		model.addAttribute("_comment", commentList);
		model.addAttribute("_course", course);
		return "course/course-style";
	}
	
	
}

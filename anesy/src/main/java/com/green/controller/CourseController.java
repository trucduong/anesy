package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course-category")
public class CourseController {
	
	@RequestMapping
	public String showCategoryListPage() {
		return "/course/category-list";
	}
}

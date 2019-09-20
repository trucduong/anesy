package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/course-category")
public class AdminCourseCategoryController {
	
	@RequestMapping
	public String showCategoryListPage() {
		return "/course/admin-category-list";
	}
}

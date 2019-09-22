package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.entity.CourseCategory;
import com.green.model.Page;
import com.green.service.CourseService;

@Controller
@RequestMapping("/admin/course-category")
public class AdminCourseCategoryController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping
	public String showListPage(@RequestParam(name="page", required = false) Integer page,
			@RequestParam(name="filter", required = false) String filter,
			Model model) {
		
		if (page == null || page < 1) {
			page = 1;
		}
		
		Page<CourseCategory> pageData = courseService.findCategories(filter, page);
		model.addAttribute("_pageData", pageData);
		
		return "/course/admin-category-list";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreatePage(Model model) {
		
		model.addAttribute("action", "create");
		return "/course/admin-category-detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleCreate(Model model) {
		
		model.addAttribute("action", "create");
		return "/course/admin-category-detail";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showUpdatePage(@PathVariable("id") int id, Model model) {
		
		
		model.addAttribute("action", "update");
		return "/course/admin-category-detail";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String handleUpdate(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("action", "update");
		return "/course/admin-category-detail";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public String handleDelete(@PathVariable("id") int id) {
		
		
		return "redirect:/course-category";
	}
}

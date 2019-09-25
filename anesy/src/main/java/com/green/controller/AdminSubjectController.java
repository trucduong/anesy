package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.entity.CourseCategory;
import com.green.entity.Subjects;
import com.green.model.Page;
import com.green.service.SubjectsService;



@Controller
@RequestMapping("/admin/subjects")
public class AdminSubjectController {
	@Autowired
	private SubjectsService subjectsService;
	
	@RequestMapping
	public String showListPage(@RequestParam(name="page", required = false) Integer page,
			@RequestParam(name="filter", required = false) String filter,
			Model model) {
		
		if (page == null || page < 1) {
			page = 1;
		}
		
		Page<Subjects> pageData = subjectsService.findSubject(filter,page);
		model.addAttribute("_pageData", pageData);
		
		return "/course/subjects";
	}
}

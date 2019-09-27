package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "subjects/subjects-list";
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreatePage(Model model) {
		
		model.addAttribute("action", "create");
		return "/subjects/subjects-detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleCreate(Model model) {
		
		model.addAttribute("action", "create");
		return "/subjects/subjects-detail";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showUpdatePage(@PathVariable("id") int id, Model model) {
		
		
		model.addAttribute("action", "update");
		return "/subjects/subjects-detail";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String handleUpdate(@PathVariable("id") int id, Model model) {
		
		model.addAttribute("action", "update");
		return "/subjects/subjects-detail";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public String handleDelete(@PathVariable("id") int id) {
		
		
		return "redirect:/admin/subjects";
	}
}

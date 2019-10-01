package com.green.controller;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.config.MessageBox;
import com.green.entity.CourseCategory;
import com.green.entity.Subjects;
import com.green.model.CategoryModel;
import com.green.model.Page;
import com.green.model.SubjectModel;
import com.green.service.SubjectsService;



@Controller
@RequestMapping("/admin/subjects")
public class AdminSubjectController {
	@Autowired
	private SubjectsService subjectsService;
	
	@Autowired
	private MessageBox messageBox;
	
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
		model.addAttribute("_subjectscategory", new Subjects());
		return "/subjects/subjects-detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleCreate(@ModelAttribute SubjectModel subjectModel) {
		
		Subjects sub = new Subjects();
		sub.setName(subjectModel.getName());
		sub.setDescription(subjectModel.getDescription());
		sub.setAvatar(subjectModel.getAvatar());
		
		subjectsService.insert(sub);;
		
		return "redirect:/admin/subjects";
	}
	
	////////////////////////////////////////////////////////////////////////////////

		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showUpdatePage(@PathVariable("id") int id, Model model) {
		Subjects sub = subjectsService.findById(id);
		if (sub == null) {
			messageBox.setMessage("Không tìm thấy category id: " + id);
			return "redirect:/admin/subjects";
		}
		
		model.addAttribute("_subjects", sub);
		
		return "/subjects/subjects-detail";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String handleUpdate(@PathVariable("id") int id,
			@ModelAttribute SubjectModel subjectModel) {
		
		Subjects sub = subjectsService.findById(id);
		
		if (sub == null) {
			messageBox.setMessage("Không tìm thấy category id: " + id);
			return "redirect:/admin/subjects";
		}

		sub.setName(subjectModel.getName());
		sub.setDescription(subjectModel.getDescription());
		sub.setAvatar(subjectModel.getAvatar());
		
		subjectsService.insert(sub);
		
		return "redirect:/admin/course-category";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public String handleDelete(@PathVariable("id") int subId, Subjects subject) {
		subjectsService.delete(subId, subject);
		return "redirect:/admin/subjects";
	}
}

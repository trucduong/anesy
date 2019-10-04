package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.config.AuthContext;
import com.green.config.MessageBox;
import com.green.entity.Lesson;
import com.green.model.LessonModel;
import com.green.model.Page;
import com.green.service.LessonService;
import com.green.service.SubjectsService;

@Controller
@RequestMapping("/admin/lesson")
public class AdminLessonController {
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private SubjectsService subjectsService;
	
	@Autowired
	private AuthContext authContext;
	
	@Autowired
	private MessageBox messageBox;
	
	@RequestMapping
	public String showListPage(@RequestParam(name="page", required = false) Integer page,
			@RequestParam(name="filter", required = false) String filter,
			Model model) {
		
		if (page == null || page < 1) {
			page = 1;
		}
		
		Page<Lesson> pageData = lessonService.findSubject(filter, page);
		model.addAttribute("_pageData", pageData);
		
		return "/lesson/admin-lesson-list";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreatePage(Model model) {
		model.addAttribute("_lesson", new Lesson());
		model.addAttribute("_subjectList", subjectsService.findAll());
		return "/lesson/admin-lesson-detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleCreate(@ModelAttribute LessonModel lesModel) {
		
		Lesson les = new Lesson();
		les.setName(lesModel.getName());
		les.setDescription(lesModel.getDescription());
		les.setSubjects(subjectsService.findById(lesModel.getSubjectsId()));
		java.util.Date date=new java.util.Date();
		les.setCreatedAt(date);
		les.setSeq(lesModel.getSeq());
		les.setAuthor(authContext.getAccountId());
		
		lessonService.insert(les);
		
		return "redirect:/admin/lesson";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showUpdatePage(@PathVariable("id") int id, Model model) {
		
		Lesson les = lessonService.findById(id);
		if (les == null) {
			messageBox.setMessage("Không tìm thấy lesson id: " + id);
			return "redirect:/admin/lesosn";
		}
		
		model.addAttribute("_lesson", les);
		model.addAttribute("_subjectList", subjectsService.findAll());
		
		return "/lesson/admin-lesson-detail";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String handleUpdate(@PathVariable("id") int id,
			@ModelAttribute LessonModel lesModel) {
		
		Lesson les = lessonService.findById(id);
		if (les == null) {
			messageBox.setMessage("Không tìm thấy lesson id: " + id);
			return "redirect:/admin/lesson";
		}

		les.setName(lesModel.getName());
		les.setDescription(lesModel.getDescription());
		les.setSubjects(subjectsService.findById(lesModel.getSubjectsId()));
		java.util.Date date=new java.util.Date();
		les.setCreatedAt(date);
		les.setSeq(lesModel.getSeq());
		les.setAuthor(authContext.getAccountId());
		
		lessonService.update(les);
		
		return "redirect:/admin/lesson";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public String handleDelete(@PathVariable("id") int id) {
		lessonService.delete(id);
		return "redirect:/admin/lesson";
	}

}

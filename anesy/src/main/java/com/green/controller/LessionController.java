package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.entity.Lesson;
import com.green.service.LessonService;

@Controller
@RequestMapping("/lession")
public class LessionController {
	@Autowired
	private LessonService lessonService;
	
	@GetMapping()
	public String index(Model model) {
		List<Lesson> lessonList = lessonService.findAll();
		
		model.addAttribute("lesson_list", lessonList);		
		
		return "/WEB-INF/LessionManagement.jsp";
	}
}

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
@RequestMapping("/lesson")
public class LessonController {
	private static final String LESSON_LIST_VIEW_NAME = "lesson-list";
	
	@Autowired
	private LessonService lessonService;
	
	@GetMapping()
	public String index(Model model) {
		List<Lesson> lessonList = lessonService.findAllWithSubjects();
		
		model.addAttribute("lesson_liswt", lessonList);
		
		return LESSON_LIST_VIEW_NAME;
	}
}

package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.entity.Lesson;
import com.green.service.LessonService;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	private String lessonCreatePage = "lesson-create";

	@Autowired
	private LessonService lessonService;

	@RequestMapping(method = RequestMethod.GET)
	public String lessonList(Model model) {
		List<Lesson> lessonList = lessonService.findAll();

		model.addAttribute("lessonList", lessonList);

		return "lesson-list";
	}

	// display create lesson form
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showAddLessonForm(Model model) {

		model.addAttribute(new Lesson());

		return lessonCreatePage;
	}

	// Process create lesson form
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String addLesson(Lesson lesson) {

		lessonService.insert(lesson);

		return "redirect:/lesson";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditLessonForm(Model model, @PathVariable int id) {

		return "/edit/{id}";
	}

	//https://o7planning.org/vi/10605/tao-mot-ung-dung-java-web-ban-hang-su-dung-spring-mvc-va-hibernate
	//https://stackoverflow.com/questions/15313290/spring-mvc-how-do-i-update-a-model-objects-attributes-using-a-controller-meth
}

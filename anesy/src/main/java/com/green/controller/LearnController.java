package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.entity.Course;
import com.green.entity.CourseSubjects;
import com.green.entity.Lesson;
import com.green.service.CourseService;
import com.green.service.LessonService;
import com.green.service.SubjectsService;

@Controller
@RequestMapping("/learning")
public class LearnController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SubjectsService subjectService;
	
	@Autowired
	private LessonService lessonService;
	
	@GetMapping("/course/{id}")
	public String courseLearn(@PathVariable(name = "id")int id,Model model) {
		Course course = courseService.findById(id);
		List<CourseSubjects> courseSubjectslist = subjectService.findListSubjects(course);
		model.addAttribute("_course", course);
		model.addAttribute("_courseSubjectlist", courseSubjectslist);
		return "/learning/learning-course";
		
	}
	
	@GetMapping("/subject/{id}")
	public String subjectLearn(@PathVariable(name = "id")int id,Model model) {
		CourseSubjects courseSubjects = subjectService.findSubject(id);
		Course course = courseService.findById(courseSubjects.getCourse().getId());
		List<Lesson> lessonList = lessonService.findLessonbySubject(courseSubjects.getSubjects());
		model.addAttribute("_course", course);
		model.addAttribute("_lessonlist", lessonList);
		model.addAttribute("_courseSubjects", courseSubjects);
		return "/learning/learning-subject";
		
	}
	
}

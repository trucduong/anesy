package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.config.MessageBox;
import com.green.entity.Exercise;
import com.green.model.ExerciseModel;
import com.green.model.Page;
import com.green.service.ExerciseService;

@Controller
@RequestMapping("/admin/exercise")
public class AdminExerciseController {
	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private MessageBox messageBox;
	
	@RequestMapping
	public String showListPage(@RequestParam(name="page", required = false) Integer page,
			@RequestParam(name="filter", required = false) String filter,
			Model model) {
		
		if (page == null || page < 1) {
			page = 1;
		}
		
		Page<Exercise> pageData = exerciseService.findExercise(filter, page);
		model.addAttribute("_pageData", pageData);
		
		return "exercise/exercise-list";
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreatePage(Model model) {
		model.addAttribute("_exercise", new Exercise());
		return "/exercise/exercise-detail";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleCreate(@ModelAttribute ExerciseModel exerciseModel) {
		
		Exercise ex = new Exercise();
		ex.setName(exerciseModel.getName());
		ex.setDescription(exerciseModel.getDescription());
		ex.setSubjects(exerciseModel.getSubjects());
		
		exerciseService.insert(ex);;
		
		return "redirect:/admin/exercise";
	}
	
	////////////////////////////////////////////////////////////////////////////////

		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showUpdatePage(@PathVariable("id") int id, Model model) {
		Exercise ex = exerciseService.findById(id);
		if (ex == null) {
			messageBox.setMessage("KhÃ´ng tÃ¬m tháº¥y exercise id: " + id);
			return "redirect:/admin/exercise";
		}
		
		model.addAttribute("_exercise", ex);
		
		return "/exercise/exercise-detail";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String handleUpdate(@PathVariable("id") int id,
			@ModelAttribute ExerciseModel exerciseModel) {
		
		Exercise ex = exerciseService.findById(id);
		
		if (ex == null) {
			messageBox.setMessage("KhÃ´ng tÃ¬m tháº¥y exercise id: " + id);
			return "redirect:/admin/exercise";
		}

		ex.setName(exerciseModel.getName());
		ex.setDescription(exerciseModel.getDescription());
		ex.setSubjects(exerciseModel.getSubjects());		
		exerciseService.insert(ex);
		
		return "redirect:/admin/exercise";
	}
	
	////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public String handleDelete(@PathVariable("id") int id, Exercise exercise) {
		exerciseService.delete(exercise);
		return "redirect:/admin/exercise";
	}
}

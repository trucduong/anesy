package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.entity.Lesson;
import com.green.model.LessonModel;
import com.green.service.LessonService;

@Controller
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/lesson-list")
	public String index(Model model) {
		List<Lesson> lessonList = lessonService.findAllWithSubjects();
		
		
		model.addAttribute("lesson_list", lessonList);
		
		return "lesson-list";
	}
	
//https://o7planning.org/vi/10605/tao-mot-ung-dung-java-web-ban-hang-su-dung-spring-mvc-va-hibernate
/*    // GET: Hiển thị lesson
    @RequestMapping(value = { "/lesson" }, method = RequestMethod.GET)
    public String product(Model model, @RequestParam(value = "id", defaultValue = "") int id) {
        Lesson lesson = null;
        
        lesson = lessonService.findById(id);
        
        model.addAttribute("lessonForm", lesson);
        return "lesson-detail";
    }
	
    // POST: Save lesson
    @RequestMapping(value = { "/lesson" }, method = RequestMethod.POST)
    @Transactional(propagation = Propagation.NEVER)
    public String productSave(Model model, //
            @ModelAttribute("lessonForm") @Validated Lesson lessonForm, //
            BindingResult result, //
            final RedirectAttributes redirectAttributes) {
 
        if (result.hasErrors()) {
            return "lesson-detail";
        }
        try {
            lessonService.update(lessonForm);
        } catch (Exception e) {
            // Need: Propagation.NEVER?
            // Cần thiết: Propagation.NEVER?
            String message = e.getMessage();
            model.addAttribute("message", message);
            // Show product form.
            return "lesson-detail";
 
        }
        return "redirect:/lesson-list";
    }*/
    
}

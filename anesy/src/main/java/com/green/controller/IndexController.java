package com.green.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.config.Alert;
import com.green.config.AuthContext;
import com.green.config.MessageBox;
import com.green.config.MsgType;
import com.green.entity.CourseCategory;
import com.green.entity.Profile;
import com.green.service.AccountService;
import com.green.service.CourseService;
import com.green.service.ProfileService;

@Controller
@RequestMapping("")
public class IndexController {

	@Autowired
	private AuthContext authContext;

	@Autowired
	private Alert alert;

	@Autowired
	private MessageBox messageBox;

	@Autowired
	private AccountService accountService;

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private CourseService courseService;

	@GetMapping()
	public String index(Model model) {
		if (authContext.isAuthenticated()) {
			int id = authContext.getAccountId();
			Profile profile = profileService.findById(id);
			model.addAttribute("_profile", profile);

		}
		
		List<CourseCategory> category_list = (List<CourseCategory>) courseService.findCategories();
		model.addAttribute("_categoryList",category_list);

		return "home";
	}

}

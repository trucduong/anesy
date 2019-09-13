package com.green.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.config.AuthContext;
import com.green.entity.Account;
import com.green.entity.Profile;
import com.green.service.AccountService;
import com.green.service.ProfileService;

@Controller
@RequestMapping("")
public class IndexController {
	@Autowired
	private AuthContext authContext;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/home")
	public String index(Model model) {
		int id = authContext.getAccountId();
		Profile profile = profileService.findbyID(id);
		model.addAttribute("_profile", profile);
		return "home";
	}
	
	@GetMapping("")
	public String index1(Model model) {
		if(!authContext.isAuthenticated()) {
			return "home";
		}
		return "redirect:/home";
	}
	
	
}

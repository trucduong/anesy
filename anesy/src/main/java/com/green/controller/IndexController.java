package com.green.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.entity.Account;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping()
	public String index(Model model) {
		return "home";
	}
	
	
}

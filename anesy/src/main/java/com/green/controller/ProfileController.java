package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@GetMapping()
	public String profile() {
		return "profile";
	}
	
	@PostMapping("image")
	public String image() {
		return "";
	}
	
	
}

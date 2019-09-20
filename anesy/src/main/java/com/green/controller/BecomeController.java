package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/become")
public class BecomeController {

	@GetMapping()
	public String becometeacher() {
		return "become-regis";
	}
	
}

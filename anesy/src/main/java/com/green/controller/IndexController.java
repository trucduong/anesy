package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.config.Alert;
import com.green.config.AuthContext;
import com.green.config.MessageBox;
import com.green.config.MsgType;
import com.green.service.AccountService;
import com.green.service.ProfileService;

@Controller
@RequestMapping("/")
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
	
	@GetMapping()
	public String index(Model model) {

		alert.addMessage("hello");
		alert.addMessage("error", MsgType.warning);
		
		messageBox.setMessage("Welcome");
		
		
		return "home";
	}
	
	
}

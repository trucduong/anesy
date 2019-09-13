package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.config.AuthContext;
import com.green.entity.Account;
import com.green.service.AccountService;

@Controller
@RequestMapping("/login")
public class LoginController {

	
	@Autowired
	private AuthContext authContext;

	@Autowired
	private AccountService accountService;

	@GetMapping()
	public String getlogin() {
		return "login";
	}

	@PostMapping()
	public String postlogin(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		Account account = accountService.findByEmail(email);
		if (!account.getPassword().equals(password)) {
			return "login";
		}
		authContext.setAccountId(account.getId());
		authContext.setEmail(account.getEmail());
		authContext.setAuthenticated(true);

		return "redirect:/home";
	}

}

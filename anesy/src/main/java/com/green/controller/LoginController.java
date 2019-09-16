package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.config.AuthContext;
import com.green.config.MessageBox;
import com.green.entity.Account;
import com.green.service.AccountService;
import com.green.service.ProfileService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private MessageBox msgBox;
	
	@Autowired
	private AuthContext authContext;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProfileService profileService;

	@GetMapping()
	public String getlogin() {
		authContext.setAuthenticated(false);
		return "login";
	}

	@PostMapping()
	public String postlogin(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		Account account = accountService.findByEmail(email);
		
		if (account== null ||!account.getPassword().equals(password)) {
			msgBox.setMessage("Tài khoản hoặc mật khẩu không đúng");
			return "login";
		}
		authContext.setAccountId(account.getId());
		authContext.setEmail(account.getEmail());
		authContext.setAuthenticated(true);
		authContext.setFullName(profileService.findById(account.getId()).getFullName());
		authContext.setUserType(profileService.findById(account.getId()).getUserType());
		
		return "redirect:/";
	}

}

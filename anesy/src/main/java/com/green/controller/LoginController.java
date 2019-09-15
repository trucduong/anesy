package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.entity.Account;
import com.green.service.AccountService;

@Controller
@RequestMapping("/login")
public class LoginController {
   @Autowired
   private AccountService accountService;
   @GetMapping()
   public String login(Model model) {
	   return "login";
   }
   @PostMapping()
  public String Login(Model model,@RequestParam(name="email",required=false) String email
		  ,@RequestParam(name="password",required=false) String password) {
	      if(email == null || email.isEmpty()) {
	    	  model.addAttribute("message", "Vui lòng nhập email");
	    	  return "login";
	      }
	      if(password == null || password.isEmpty()) {
	    	  model.addAttribute("message","Vui lòng nhập password");
	    	  return "login";
	      }
	          Account account = accountService.findByEmail(email);
	          if(account == null || !password.equals(account.getPassword())) {
	        	  model.addAttribute("message","Đăng nhập thất bại");
	        	  return "login";
	          }
	          	  return "redirect:/";
   }
}

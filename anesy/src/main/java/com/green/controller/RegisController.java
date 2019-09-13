package com.green.controller;

import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.entity.Account;
import com.green.entity.Profile;
import com.green.exception.MyException;
import com.green.model.RegisModel;
import com.green.service.AccountService;
import com.green.service.ProfileService;
import com.green.util.EmailUtils;

@Controller
@RequestMapping("/regis")
public class RegisController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final String REGIS_VIEW_NAME = "regis";
	
	@Autowired
	private AccountService accountService;
	@GetMapping
	public String showLoginPage() {
		return REGIS_VIEW_NAME;
	}
	@PostMapping
	public String processSubmitRegis(@ModelAttribute("regisModel") RegisModel regisModel,
									Model model, ServletRequest request) {
		// kiem tra
		if (regisModel.getEmail() == null || regisModel.getEmail().isEmpty()) {
			model.addAttribute("error", "Vui long nhap email!");
			return REGIS_VIEW_NAME;
		}
		
		if (regisModel.getFullName() == null || regisModel.getFullName().isEmpty()) {
			model.addAttribute("error", "Vui long nhap ho ten!");
			return REGIS_VIEW_NAME;
		}
		
		try {
			accountService.regis(regisModel.getEmail(), regisModel.getFullName(), regisModel.getUserType());
		} catch(MyException le) {
			model.addAttribute("error", le.getMessage());
			return REGIS_VIEW_NAME;
		} catch (Exception e) {
			model.addAttribute("error", "Loi, vui long thu lai");
			return REGIS_VIEW_NAME;
		}
		
		return "redirect:/";
	}

}

package com.green.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.config.Alert;
import com.green.config.MessageBox;
import com.green.config.MsgType;
import com.green.exception.MyException;
import com.green.model.LoginModel;
import com.green.service.AccountService;

@Controller
@RequestMapping("/resetpass")
public class ResetPassController extends HttpServlet{
	private static final String RESET_VIEW_NAME = "resetpass";
	
	@Autowired
	private Alert alert;
	
	@Autowired
	private MessageBox messageBox;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping
	public String showLoginPage() {
		return RESET_VIEW_NAME;
	}
	
	@PostMapping
	public String processSubmitRegis(HttpServletRequest request) {
		// kiem tra
		if (request.getParameter("email") == null || request.getParameter("email").isEmpty()) {
			alert.addMessage("Vui long nhap email!", MsgType.warning);
			return RESET_VIEW_NAME;
		}
		
		try {
			accountService.resetPassword(request.getParameter("email"));
		} catch(MyException le) {
			alert.addMessage(le.getMessage(), MsgType.danger);
			return RESET_VIEW_NAME;
		} catch (Exception e) {
			alert.addMessage("Loi, vui long thu lai",MsgType.danger);
			return RESET_VIEW_NAME;
		}
		
		messageBox.setMessage("Vui long kiem tra email de nhan mat khau moi!");
		
		return "redirect:/login";
	}
}

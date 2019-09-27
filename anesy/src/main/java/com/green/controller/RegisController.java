package com.green.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;

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
import com.green.model.RegisModel;
import com.green.service.AccountService;

@Controller
@RequestMapping("/regis")
public class RegisController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final String REGIS_VIEW_NAME = "regis";
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private Alert alert;
	
	@Autowired
	private MessageBox messageBox;
	
	@GetMapping
	public String showLoginPage() {
		return REGIS_VIEW_NAME;
	}
	@PostMapping
	public String processSubmitRegis(@ModelAttribute("regisModel") RegisModel regisModel,
									Model model, ServletRequest request) {
		// kiem tra
		if (regisModel.getEmail() == null || regisModel.getEmail().isEmpty()) {
			alert.addMessage("Vui long nhap email!", MsgType.warning);
			return REGIS_VIEW_NAME;
		}
		
		if (regisModel.getFullName() == null || regisModel.getFullName().isEmpty()) {
			alert.addMessage("Vui long nhap ho ten!", MsgType.warning);
			return REGIS_VIEW_NAME;
		}
		
		try {
			accountService.regis(regisModel.getEmail(), regisModel.getFullName(), regisModel.getUserType());
		} catch(MyException le) {
			alert.addMessage(le.getMessage(), MsgType.danger);
			return REGIS_VIEW_NAME;
		} catch (Exception e) {
			alert.addMessage("Loi, vui long thu lai",MsgType.danger);
			return REGIS_VIEW_NAME;
		}
		
		messageBox.setMessage("Đăng ký thành công.<br>Mật khẩu đã được gửi vào email <strong>"+regisModel.getEmail()+"</strong>");
		
		return "redirect:/";
	}

}

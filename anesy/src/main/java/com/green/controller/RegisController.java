package com.green.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.config.Alert;
import com.green.config.AuthContext;
import com.green.config.MessageBox;
import com.green.config.MsgType;
import com.green.entity.Profile;
import com.green.exception.MyException;
import com.green.model.RegisModel;
import com.green.service.AccountService;
import com.green.service.ProfileService;

@Controller
@RequestMapping("/regis")
public class RegisController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private static final String REGIS_VIEW_NAME = "regis";
	@Autowired
	private AuthContext authContext;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProfileService profileService;
	
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
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
		Matcher matcher = pattern.matcher(regisModel.getEmail());
				
		if(!matcher.matches()) {
			alert.addMessage("Email khong dung dinh dang", MsgType.warning);
			return REGIS_VIEW_NAME;
		}
		
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
	
	@PostMapping("/teacher")
	public String becomeTeacher(Model model, @RequestParam(name = "name")String name,
											@RequestParam(name = "specialize")String specialize,
											@RequestParam(name = "phone")String phone,
											@RequestParam(name = "description")String description,
											@RequestParam(name = "experience")String experience,
											@RequestParam(name = "id")int id) {
											Profile profile = profileService.findById(id);
											profile.setFullName(name);
											profile.setPhone(phone);
											profile.setDescription(description);
											profile.setSpecialize(specialize);
											profile.setUserType(2);
											profileService.update(profile);
											authContext.setProfile(profile);
											alert.addMessage("Đăng ký thành công", MsgType.success);
											return "redirect:/";
		
		
	}

}

package com.green.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.config.AuthContext;
import com.green.dao.BaseDao;
import com.green.dao.ProfileDao;
import com.green.entity.Account;
import com.green.entity.Profile;
import com.green.service.AccountService;
import com.green.service.ProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private ProfileService profileservice;
	
	@Autowired
	private AccountService accountservice;

	@Autowired
	private AuthContext authContext;
	
	@GetMapping()
	public String showDefaultPage() {
		return "redirect: /profile/info";
	}
	
	@GetMapping("/info")
	public String info(HttpServletRequest request) {
		
		int id = authContext.getAccountId();
		Account account = accountservice.findById(id);
		Profile profile = profileservice.findbyID(account.getId());
		request.setAttribute("_profile", profile);
		return "profile/info";
	}

	@PostMapping("image")
	public String image() {
		return "";
	}

	@GetMapping("/password")
	public String password(HttpServletRequest request, Model model) {
		return "profile-password";
	}

	@GetMapping("/history")
	public String history() {
		return "profile-historylearning";
	}

	@GetMapping("/certificate")
	public String certificate() {
		return "profile-certificate";
	}

	@PostMapping("/info")
	public String updateinfo(Model model, HttpServletRequest request) {

		String name = (String) request.getParameter("name");
		String phone = (String) request.getParameter("phone");
		String gender = (String) request.getParameter("gender");
		String birthday = (String) request.getParameter("birthday");
		String address = (String) request.getParameter("address");
		String userType = (String) request.getParameter("usertype");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate;
		try {
			birthdayDate = (Date) sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
			return "profile-info";
		}
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("current_user");
		Profile profile = new Profile();
		profile.setAccountId(account.getId());
		profile.setAddress(address);
		profile.setEmail(account.getEmail());
		profile.setFullName(name);
		profile.setGender(gender);
		profile.setPhone(phone);
		profile.setUserType(Integer.parseInt(userType));
		profile.setBirthDate(birthdayDate);

		profileservice.update(profile);
		return "profile-info";
	}

	@PostMapping("/password")
	public String updatepassword(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("current_user");
		String oldpass = (String) request.getParameter("oldpass");
		String newpass = (String) request.getParameter("newpass");
		String newpass1 = (String) request.getParameter("newpass1");

		if (!account.getPassword().equals(oldpass) || account.getPassword().equals(newpass)
				|| !newpass.equals(newpass1)) {
			return "profile-password";
		}
		
		account.setPassword(newpass);
		accountservice.update(account.getId(), account);
		session.setAttribute("current_user", account);
		return "profile-password";
	}

}

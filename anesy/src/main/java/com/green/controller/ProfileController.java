package com.green.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.config.Alert;
import com.green.config.AuthContext;
import com.green.config.MsgType;
import com.green.dao.BaseDao;
import com.green.dao.ProfileDao;
import com.green.entity.Account;
import com.green.entity.Course;
import com.green.entity.Profile;
import com.green.service.AccountService;
import com.green.service.CourseService;
import com.green.service.ProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private Alert alert;
	
	@Autowired
	private ProfileService profileservice;
	
	@Autowired
	private AccountService accountservice;

	@Autowired
	private AuthContext authContext;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping()
	public String showDefaultPage() {
		return "redirect:/profile/info";
	}
	
	
	
	@GetMapping("/info")
	public String info(HttpServletRequest request) {
		
		int id = authContext.getAccountId();
		Profile profile = profileservice.findById(id);
		request.setAttribute("_profile", profile);
		return "profile/info";
	}

	@PostMapping("image")
	public String image() {
		return "";
	}

	@GetMapping("/password")
	public String password(HttpServletRequest request, Model model) {
		return "profile/password";
	}

	@GetMapping("/history")
	public String history() {
		return "profile/historylearning";
	}

	@GetMapping("/certificate")
	public String certificate() {
		return "profile/certificate";
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
			return "profile/info";
		}
		HttpSession session = request.getSession();
		int id = authContext.getAccountId();
		String email = authContext.getEmail();
		Profile profile = new Profile();
		profile.setAccountId(id);
		profile.setAddress(address);
		profile.setEmail(email);
		profile.setFullName(name);
		profile.setGender(gender);
		profile.setPhone(phone);
		profile.setUserType(Integer.parseInt(userType));
		profile.setBirthDate(birthdayDate);

		profileservice.update(profile);
		return "redirect:/profile/info";
	}

	@PostMapping("/password")
	public String updatepassword(@RequestParam(name = "oldpass") String oldpass,
			@RequestParam(name = "newpass") String newpass,
			@RequestParam(name = "newpass1") String newpass1, Model model) {

		int id = authContext.getAccountId();
		Account account = accountservice.findById(id);

		if (!account.getPassword().equals(oldpass) || account.getPassword().equals(newpass)
				|| !newpass.equals(newpass1)) {
			alert.addMessage("Cập nhật thất bại", MsgType.danger );
			return "profile/password";
		}
		
		account.setPassword(newpass);
		accountservice.update(account);
		alert.addMessage("Cập nhật thành công");
		return "profile/password";
	}
	
	
	@GetMapping("/{idteacher}")
	public String showTeacher(@PathVariable(name = "idteacher")int id, Model model) {
		Profile profile = profileservice.findById(id);
		List<Course> courselist = courseService.findByAuthor(profile);
		int stutotal;
		int commenttotal;
		for(Course course : courselist) {
			
		}
		model.addAttribute("_courselist", courselist);
		model.addAttribute("_teacherprofile", profile);
		return "teacher-profile";
	}

}

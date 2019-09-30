package com.green.controller;

import java.io.File;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.config.Alert;
import com.green.config.AuthContext;
import com.green.config.MsgType;
import com.green.entity.Account;
import com.green.entity.Course;
import com.green.entity.Profile;
import com.green.model.ProfileModel;
import com.green.service.AccountService;
import com.green.service.CourseService;
import com.green.service.ProfileService;
import com.green.util.ApplicationConfig;

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
	
	private String IMAGE_DIR;

	@Autowired
	ServletContext context;

	@PostConstruct
	public void init() {
		IMAGE_DIR = ApplicationConfig.getConfig("image.dir");
		File filesDir = new File(IMAGE_DIR);
		if (!filesDir.exists()) {
			filesDir.mkdirs();
		}

	}
	
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
	
	@PostMapping("/info")
	public String updateinfo(@ModelAttribute ProfileModel model, HttpServletRequest request) {
		Profile profile = profileservice.findById(authContext.getAccountId());
		
		profile.setAddress(model.getAddress());
		profile.setBirthDate(model.getBirthDate());
		profile.setFullName(model.getFullName());
		profile.setGender(model.getGender());
		profile.setPhone(model.getFullName());
		profile.setEmail(model.getEmail());
		
		profileservice.update(profile);
		authContext.setProfile(profile);
		
		return "redirect:/profile/info";
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

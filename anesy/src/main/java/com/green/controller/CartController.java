package com.green.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.config.Alert;
import com.green.config.AuthContext;
import com.green.config.MsgType;
import com.green.entity.Cart;
import com.green.entity.Course;
import com.green.entity.CourseRegistration;
import com.green.entity.Progress;
import com.green.service.CourseService;

@Controller
@RequestMapping("cart")
public class CartController {
	@Autowired
	private Alert alert;
	
	@Autowired
	private AuthContext authContext;
	
	@Autowired
	private CourseService courseService ;
	
	@GetMapping
	public String showCart() {
		return "cart";
	}
	
	@PostMapping("/add")
	public String handlingCartAdd(HttpServletRequest request,@RequestParam(name = "courseId")int id, Model model) {
		
		
		
			Cart cart = (Cart) request.getSession().getAttribute("CART");
			if(cart == null) {
				cart = new Cart();
			}
			
			Course course = courseService.findById(id);
			
			cart.getDetails().put(id, course);
			cart.calculate();
			request.getSession().setAttribute("CART", cart);
			
		
		return "redirect:/course/" + id;
	}
	
	@PostMapping("/remove")
	public String handlingCartRemove(HttpServletRequest request,@RequestParam(name = "courseId")int id, Model model) {
		
		Cart cart1 = (Cart) request.getSession().getAttribute("CART");
		if(cart1 == null) {
			cart1 = new Cart();
		}
		
		cart1.getDetails().remove(id);
		cart1.calculate();
		request.getSession().setAttribute("CART", cart1);
		return "redirect:/cart";
	}
	
	@PostMapping("/pay")
	public String handlingCartPay(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("CART");
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, 1);
		Date endDate = c.getTime();
		
		for (int code : cart.getDetails().keySet()) {
			Course course = cart.getDetails().get(code);
			CourseRegistration courseRegistration = new CourseRegistration();
			courseRegistration.setCourse(course);
			courseRegistration.setAuthor(course.getAuthor().getAccountId());
			courseRegistration.setStudent(authContext.getProfile());
			courseRegistration.setStatus(Progress.NEW);
			courseRegistration.setRegisDate(date);
			courseRegistration.setEndDate(endDate);
			courseService.saveCourseRegis(courseRegistration);
		}
		request.getSession().setAttribute("CART", new Cart());
		alert.addMessage("Thanh toán thành công - Vào khóa học của tôi để bắt đầu học", MsgType.success);
		return "redirect:/cart";
	}
}

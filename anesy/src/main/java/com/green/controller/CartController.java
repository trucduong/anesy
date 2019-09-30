package com.green.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.entity.Cart;
import com.green.entity.Course;
import com.green.service.CourseService;

@Controller
@RequestMapping("cart")
public class CartController {
	
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
}

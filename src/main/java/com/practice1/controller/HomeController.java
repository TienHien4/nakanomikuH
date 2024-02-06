package com.practice1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice1.entities.Role;
import com.practice1.entities.User;
import com.practice1.service.UserService;

@Controller

public class HomeController {
	

	@Autowired
	private UserService userService;
	
	@GetMapping("/signin")
	public String Login()
	{
		return "home/login";
	}
	
	@GetMapping("/register")
	public String Register(Model model)
	{

		User user = new User();
		model.addAttribute("user", user);
		return "home/register";
	}
	
	@PostMapping("/createUser")
	public String createrUser(User user) {
		userService.createUser(user);
		return "redirect:/register";
	}
	
//	@PostMapping("/createUser")
//	public String createuser(@ModelAttribute User user, HttpSession session) {
//
//		// System.out.println(user);
//
//		boolean f = userService.checkEmail(user.getEmail());
//
//		if (f) {
//			session.setAttribute("msg", "Email Id alreday exists");
//		}
//
//		else {
//			User userDtls = userService.createUser(user);
//			if (userDtls != null) {
//				session.setAttribute("msg", "Register Sucessfully");
//			} else {
//				session.setAttribute("msg", "Something wrong on server");
//			}
//		}
//
//		return "redirect:/home/register";
//	}

}


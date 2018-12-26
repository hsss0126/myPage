package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired UserService userService;

	@RequestMapping("index")
	public String index() {
		return "user/index";
	}
	
	@RequestMapping("logout")
	public String logout(@RequestParam("id") int id) {
		userService.logout(id);
		return "redirect:logout_processing";
	}
	
	@RequestMapping("mypage")
	public String mypage() {
		return "user/mypage";
	}
}

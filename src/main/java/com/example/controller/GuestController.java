package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.User;
import com.example.model.UserJoinModel;
import com.example.service.MailService;
import com.example.service.UserService;

@Controller
@RequestMapping("guest")
public class GuestController {

	@Autowired UserService userService;
	@Autowired MailService mailService;

	@RequestMapping("index")
	public String index() {
		return "guest/index";
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "guest/login";
	}

	@RequestMapping(value="join", method=RequestMethod.GET)
	public String join(UserJoinModel userJoinModel, Model model) {
		return "guest/join";
	}

	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(@Valid @ModelAttribute("userJoinModel") UserJoinModel userJoinModel, Model model, BindingResult bindingResult) {
		if(!userService.isVaild(userJoinModel, bindingResult)) {
			return "guest/join";
		}
		User user = userJoinModel.toUser();
		user = userService.join(user);
		mailService.sendMail(user);
		return "redirect:login?joinSuccess";
		
//		System.out.println("redirect:/shs/mail/sendMail?loginEmail="+userJoinModel.getLoginEmail());
//		return "redirect:/shs/mail/sendMail?loginEmail="+userJoinModel.getLoginEmail();
	}
	
	@RequestMapping(value="certify", method=RequestMethod.GET)
	public String certify(@RequestParam int id) {
		userService.certify(id); 
		return "redirect:login?certifySuccess";
	}

}

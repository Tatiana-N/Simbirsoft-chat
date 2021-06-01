package com.simbirsoft.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {
	@RequestMapping("/login")
	@ResponseBody
	public ModelAndView welcome(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	@RequestMapping("/add")
	@ResponseBody
	public ModelAndView add(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addUser");
		return modelAndView;
	}
}

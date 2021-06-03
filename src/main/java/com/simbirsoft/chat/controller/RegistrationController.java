package com.simbirsoft.chat.controller;

import com.simbirsoft.chat.model.Users;
import com.simbirsoft.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new Users());
		
		return "login";
	}
	
	@PostMapping("/registration")
	public String addUser(@ModelAttribute("userForm") @Valid Users userForm, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		if (!userForm.getPassword().equals(userForm.getPassword())) {
			model.addAttribute("passwordError", "Пароли не совпадают");
			return "registration";
		}
		if (userService.createUser(userForm.getLogin()) != null) {
			model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
			return "registration";
		}
		
		return "redirect:/";
	}
}
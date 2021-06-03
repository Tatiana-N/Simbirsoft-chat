package com.simbirsoft.chat.controller;

import com.simbirsoft.chat.model.Users;
import com.simbirsoft.chat.service.UserService;
import com.simbirsoft.chat.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;


@RestController
public class UserController {
	final UserService userService;
	
	public UserController(@Autowired UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("users/add/{name}")
	public String createUser(@PathVariable String name) {
		//валидация
		userService.createUser(name);
		return String.format("Юзер %s создан!", name);
	}
	
	//	@RequestMapping("/login/{name}/password/{password}")
//	public String logIn(@PathVariable String name, @PathVariable String password) {
//		//валидация
//	//	boolean success = userService.logIn(name, password);
//	//	return success? String.format("Добро пожаловать, %s!", name) : String.format("Введена неверная комбинация логина и пароля", name) ;
//	}
	//удаление юзера
	@DeleteMapping("users/delete/{UserName}")
	public String deleteUser(@PathVariable String UserName) {
		//валидация
		Users users = userService.deleteUser(UserName);
		return String.format("Юзер %s удалён!", users.getLogin());
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("add");
		return modelAndView;
	}
	
	@GetMapping("/chat")
	@ResponseBody
	public String login(@PathVariable String Login, @PathVariable String password) {
		
		return "user";
	}
	
	//получение всех юзеров
	@RequestMapping("users/getAllUsers")
	public String getAll() {
		//валидация
		List<Users> allUsersForUser = userService.getAllUsers();
		String string = Utils.getStringFromList(allUsersForUser).toString();
		return String.format("Юзеры :\n %s", string);
	}
}
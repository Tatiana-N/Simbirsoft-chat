//package com.simbirsoft.chat.controller;
//
//import com.simbirsoft.chat.model.Users;
//import com.simbirsoft.chat.service.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//public class UserController {
//	@Autowired
//	RoleService roleService;
//	@RequestMapping("/{id}")
//	//@PathVariable Один из распространённых способов передачи параметров запроса — в виде частей адреса запроса.
//	//http://localhost:8080/Tania -> Hello Tania!
//	public String getFirst(@PathVariable int id) {
//		//регистрация или вход
//		return String.format("Hello %s!", roleService.find(id).getLogin());
//	}
//
//	@RequestMapping("/login/{name}")
//	//@PathVariable Один из распространённых способов передачи параметров запроса — в виде частей адреса запроса.
//	//http://localhost:8080/Tania -> Hello Tania!
//	public void getSec( @PathVariable String name) {
////		roleService.save(name);
//		//регистрация или вход
//	}
//	@RequestMapping("/{login}/{password}")
//	//@PathVariable Один из распространённых способов передачи параметров запроса — в виде частей адреса запроса.
//	//http://localhost:8080/Tania -> Hello Tania!
//	public void logIn(@PathVariable String login, @PathVariable String password) {
//
//		//регистрация или вход
//	}
//
//	@RequestMapping("/{login}/{id}role")
//	//@PathVariable Один из распространённых способов передачи параметров запроса — в виде частей адреса запроса.
//	//http://localhost:8080/Tania -> Hello Tania!
//	public void setRole(@PathVariable String login, @PathVariable int id) {
//	//	Users users = roleService.setRoleForUser(login, id);
//		//регистрация или вход
//	}
//	@RequestMapping("/{id}getRole/")
//	//@PathVariable Один из распространённых способов передачи параметров запроса — в виде частей адреса запроса.
//	//http://localhost:8080/Tania -> Hello Tania!
//	public String getRole(@PathVariable int id) {
//		List<Users> role = roleService.getRole(id);
//		return role.get(0).toString();
//		//регистрация или вход
//	}
//}
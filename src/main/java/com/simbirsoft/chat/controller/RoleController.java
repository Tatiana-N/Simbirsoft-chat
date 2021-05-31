package com.simbirsoft.chat.controller;

import com.simbirsoft.chat.model.Roles;
import com.simbirsoft.chat.model.Users;
import com.simbirsoft.chat.service.RoleService;
import com.simbirsoft.chat.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/role")
public class RoleController {
	final RoleService roleService;
	
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	//добавление роли
	@RequestMapping("/add/{name}")
	public String createRole(@PathVariable String name) {
		//валидация
		roleService.createRole(name);
		return String.format("Роль %s создана!", name);
	}
	
	//удаление роли
	@DeleteMapping("delete/{roleName}")
	public String deleteRole(@PathVariable String roleName) {
		//валидация
		Roles roles = roleService.deleteRole(roleName);
		return String.format("Роль %s удалена!", roles.getName());
	}
	
	//установление роли
	@RequestMapping("/{login}/set/{roleName}")
	public String setRole(@PathVariable String login, @PathVariable String roleName) {
		//валидация
		Users save = roleService.setRoleForUser(login, roleName);
		return String.format("Юзеру %s установлена роль %s!", save.getLogin(), roleName);
	}
	
	//удаление роли = блокировка пользователя
	@RequestMapping("/{login}/deleteRole")
	public String deleteRole(@PathVariable String login, @PathVariable String roleName) {
		//валидация
		Users save = roleService.setRoleForUser(login, "Blocked_User");
		return String.format("У Юзера %s удалена роль %s!", save.getLogin(), roleName);
	}
	
	//получение всех юзеров с данной ролью
	@RequestMapping("/getAll/{roleName}")
	public String getAll(@PathVariable String roleName) {
		//валидация
		List<Users> allUsersForRole = roleService.getAllUsersForRole(roleName);
		String string = Utils.getStringFromList(allUsersForRole).toString();
		return String.format("Юзеры с ролью %s :\n %s", roleName, string);
	}
}
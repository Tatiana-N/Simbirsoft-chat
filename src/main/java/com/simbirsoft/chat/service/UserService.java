package com.simbirsoft.chat.service;

import com.simbirsoft.chat.model.Users;
import com.simbirsoft.chat.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	private UserRepo userRepo;
	
	public UserService(@Autowired UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public void createUser(String name) {
		Users users = new Users();
		users.setLogin(name);
		users.setPassword(name + name);
		userRepo.save(users);
	}
	
	public Users deleteUser(String userName) {
		Users byLogin = userRepo.getByLogin(userName);
		userRepo.delete(byLogin);
		return byLogin;
	}
	
	public List<Users> getAllUsers() {
		return userRepo.findAll();
	}
}

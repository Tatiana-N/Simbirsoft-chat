package com.simbirsoft.chat.service;

import com.simbirsoft.chat.model.Users;
import com.simbirsoft.chat.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
	private UserRepo userRepo;
	
	public UserService(@Autowired UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public Users createUser(String name) {
		Users users = new Users();
		users.setLogin(name);
		users.setPassword(name + name);
		userRepo.save(users);
		return users;
	}
	
	public Users deleteUser(String userName) {
		Users byLogin = userRepo.getByLogin(userName);
		userRepo.delete(byLogin);
		return byLogin;
	}
	
	public List<Users> getAllUsers() {
		return userRepo.findAll();
	}
	
	public void deleteUser(int userId) {
		Users byLogin = userRepo.getById(userId);
		userRepo.delete(byLogin);
	}
	
	public Object getAllUsersById(Integer userId) {
		List<Users> list = new ArrayList<>();
		list.add(userRepo.findById(userId).get());
		return list;
	}
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return userRepo.getByLogin(s);
	}
}

package com.simbirsoft.chat.service;

import com.simbirsoft.chat.model.Roles;
import com.simbirsoft.chat.model.Users;
import com.simbirsoft.chat.repository.RoleRepo;
import com.simbirsoft.chat.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.h2.tools.Server;

@Service
public class RoleService {
	
	private RoleRepo roleRepo;
	private UserRepo userRepo;
	
	public RoleService(@Autowired UserRepo userRepository, @Autowired RoleRepo roleRepository) throws SQLException {
		this.userRepo = userRepository;
		this.roleRepo = roleRepository;
		Server.createTcpServer().start();
	}
	
	public Users setRoleForUser(String login, String name) {
		Optional<Users> first = userRepo.findAll().stream().filter(t -> t.getLogin().equals(login)).findFirst();
		Roles byId = roleRepo.findByName(name);
		ArrayList<Users> objects = new ArrayList<>();
		Users users = first.get();
		users.setRoles(byId);
		objects.add(users);
		byId.setTenants(objects);
		roleRepo.flush();
		userRepo.flush();
		return first.get();
	}
	public List<Users> getAllUsersForRole(String name) {
		Roles byName = roleRepo.findByName(name);
		return 	getAllUsersForRole(byName.getId());
	}
	public List<Users> getAllUsersForRole(int id) {
		Optional<Roles> byId = roleRepo.findById(id);
		Roles roles = byId.get();
		System.out.println(roles);
		return roles.getTenants();
	}
	
	public Roles deleteRole(String name) {
		Roles byId = roleRepo.findByName(name);
		int id = byId.getId();
		roleRepo.deleteById(id);
		return byId;
	}
	
	public void createRole(String name) {
		Roles roles = new Roles();
		roles.setName(name);
		roleRepo.save(roles);
	}
}

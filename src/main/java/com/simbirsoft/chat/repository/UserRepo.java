package com.simbirsoft.chat.repository;

import com.simbirsoft.chat.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
	Users getByLogin(String login);
}

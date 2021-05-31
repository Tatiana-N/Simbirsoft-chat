package com.simbirsoft.chat.repository;

import com.simbirsoft.chat.model.Roles;
import org.h2.jdbc.JdbcPreparedStatementBackwardsCompat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepo extends JpaRepository<Roles,Integer>
{
	Roles findByName(String name);
	
}

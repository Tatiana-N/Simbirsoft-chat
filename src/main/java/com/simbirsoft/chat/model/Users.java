package com.simbirsoft.chat.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Data
public class Users {
	@Id
	@GeneratedValue
	private int id;
	private String login;
	private String password;
	@ManyToOne
	@JoinColumn(name = "roles_id")
	private Roles roles;
}

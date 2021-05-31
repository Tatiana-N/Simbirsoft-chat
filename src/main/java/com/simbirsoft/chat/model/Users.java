package com.simbirsoft.chat.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@EqualsAndHashCode
@ToString
@Data
public class Users {
	@Id
	@GeneratedValue
	private int id;
	@Column(unique = true)
	private String login;
	private String password;
	@ManyToOne
	private Roles roles;
}

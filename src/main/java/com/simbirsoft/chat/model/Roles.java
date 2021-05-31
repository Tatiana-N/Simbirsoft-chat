package com.simbirsoft.chat.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Roles {
	@Id
	@GeneratedValue
	private int id;
	private String name;
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "roles_id")
//	private List<Users> users = new ArrayList<>();
@OneToMany
@JoinColumn	(name = "roles")
private List<Users> tenants;
}

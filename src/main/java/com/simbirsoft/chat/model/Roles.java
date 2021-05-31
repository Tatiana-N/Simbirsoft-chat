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
	@Column(unique = true)
	private String name;
	@OneToMany
	@JoinColumn(name = "roles")
	private List<Users> tenants;
	
	@Override
	public String toString() {
		return "Roles{" + "id=" + id + ", name='" + name + '\'' + ", tenants=" + tenants.getClass() + '}';
	}
}

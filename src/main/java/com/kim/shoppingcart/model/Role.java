package com.kim.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users = new ArrayList<>();

	public Role(String name, List<User> users) {
		super();
		this.name = name;
		this.users = users;
	}
	
	
}

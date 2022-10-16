package com.kim.shoppingcart.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Long id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable=false)
	private String password;
	
//	@OneToOne
//	@JoinColumn(name="cart_id")
//	@Transient
//	private Cart cart;

	
	
	@OneToMany(targetEntity = OrderDetails.class)
	private Set<OrderDetails> orders;
	
	
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(
			name= "users_roles",
			joinColumns= {@JoinColumn(name="user_id",referencedColumnName="id")},
			inverseJoinColumns= {@JoinColumn(name="role_id",referencedColumnName="id")}
			)
	private List<Role> roles = new ArrayList<>();
	
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public void updateEmail(String newEmail) {
		email = newEmail;
	}
	
	public void updatePassword(String newPw) {
		password = newPw;
	}


	
	
	
	
	

}

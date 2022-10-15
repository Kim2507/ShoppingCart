package com.kim.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kim.shoppingcart.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);

}

package com.kim.shoppingcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kim.shoppingcart.model.ProductDetails;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<ProductDetails, Long> {

	Optional<ProductDetails> findById(Long id);
	ProductDetails findByName(String name);

}

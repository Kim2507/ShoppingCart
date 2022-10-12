package com.kim.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kim.shoppingcart.model.ProductDetails;

public interface ProductRepository extends JpaRepository<ProductDetails, Integer> {

}

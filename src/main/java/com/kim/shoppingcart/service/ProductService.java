package com.kim.shoppingcart.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kim.shoppingcart.model.ProductDetails;

public interface ProductService {
	ProductDetails findById(Long id);
	ProductDetails findByName(String name);
	

   
}

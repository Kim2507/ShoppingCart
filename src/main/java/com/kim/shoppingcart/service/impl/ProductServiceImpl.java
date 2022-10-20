package com.kim.shoppingcart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.ProductRepository;
import com.kim.shoppingcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private final ProductRepository productRepo;

   
    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }


	@Override
	public ProductDetails findByName(String name) {
		return productRepo.findByName(name);
	}


	@Override
	public ProductDetails findById(Long id) {
		return productRepo.findById(id).get();
	}


	
    
   
    
	

}

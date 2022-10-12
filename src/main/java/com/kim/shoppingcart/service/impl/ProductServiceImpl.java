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
	private final ProductRepository productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }
    
	@Override
	public Optional<ProductDetails> findById(Integer id) {
		return productRepo.findById(id);
	}

	@Override
	public Page<ProductDetails> findAllProductsPageable(Pageable pageable) {
		return productRepo.findAll(pageable);
	}

}

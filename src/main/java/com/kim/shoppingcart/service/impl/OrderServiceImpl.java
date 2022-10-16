package com.kim.shoppingcart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kim.shoppingcart.model.OrderDetails;
import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.OrderRepository;
import com.kim.shoppingcart.repository.ProductRepository;
import com.kim.shoppingcart.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	private final OrderRepository orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }
    
	@Override
	public Optional<OrderDetails> findById(Integer id) {
		return orderRepo.findById(id);
	}

	@Override
	public Page<OrderDetails> findAllOrdersPageable(Pageable pageable) {
		return orderRepo.findAll(pageable);
	}


	
}

package com.kim.shoppingcart.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kim.shoppingcart.model.OrderDetails;
import com.kim.shoppingcart.model.ProductDetails;

public interface OrderService {
	Optional<OrderDetails> findById(Integer id);

    Page<OrderDetails> findAllOrdersPageable(Pageable pageable);

}

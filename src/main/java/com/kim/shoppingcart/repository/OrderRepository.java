package com.kim.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kim.shoppingcart.model.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

}

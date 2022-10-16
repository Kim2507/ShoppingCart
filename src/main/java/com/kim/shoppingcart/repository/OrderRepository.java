package com.kim.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kim.shoppingcart.model.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

}

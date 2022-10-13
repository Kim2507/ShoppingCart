package com.kim.shoppingcart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;


@NamedQuery(name = "getAllOrders", query = "from OrderDetails" )

	

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="orders")
public class OrderDetails implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Integer orderId;

	@ManyToMany(targetEntity=ProductDetails.class)
	private Set productsSet;
	
	
	
	

	public Set getProductsSet() {
		return productsSet;
	}

	public void setProductsSet(Set productsSet) {
		this.productsSet = productsSet;
	}

	
	
	
	
}

package com.kim.shoppingcart.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity 
@Table(name="products")
public class ProductDetails implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Integer productId;
	private String name;
	private String description;
	private double price;
	private int stockQuantity;

	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	public ProductDetails(String name, String description, double price, int quantity) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockQuantity = quantity;
	}
	
	public void addStock(int quantity) {
		this.stockQuantity +=quantity;
	}
	
	public void removeStock(int quantity) {
		this.stockQuantity -=quantity;
	}
	
	
}

package com.kim.shoppingcart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Table

@AllArgsConstructor
public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private final double TAX_RATE = 0.05;

	private double preTaxPrice;
	private double totalPrice;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User userID;
	
	@OneToMany(targetEntity=ProductDetails.class)
	private Set<ProductDetails> productsList;

	@Transient
	private Map<ProductDetails,Integer> productsMap;
	
	public Cart() {}
	
	public Cart(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	

	public void addProduct(ProductDetails product) {
		productsList.add(product);
	}

    public void removeProduct(ProductDetails product) {
    	productsList.remove(product);
    }
	
	public Map<ProductDetails,Integer> getProductsMap(){
		productsMap = new HashMap<>();
		for(ProductDetails p : getProductsList()) {
			Integer productCounter = productsMap.get(p);
			productsMap.put(p,(productCounter==null)?1:productCounter+1);
		}
		return productsMap;
	}
	
	

	public double getPreTaxPrice() {
		productsMap.forEach((key,value)->{
			preTaxPrice += key.getPrice()*value;
		});
		return preTaxPrice;
	}
	
	public double getTotalPrice() {
		totalPrice= preTaxPrice*(1+TAX_RATE);
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", TAX_RATE=" + TAX_RATE + ", preTax=" + preTaxPrice + ", total=" + totalPrice
				 + ", productsMap=" + productsMap + "]";
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public Set<ProductDetails> getProductsList() {
		return productsList;
	}

	public void setProductsList(Set<ProductDetails> productsList) {
		this.productsList = productsList;
	}

	public double getTAX_RATE() {
		return TAX_RATE;
	}

	public void setPreTaxPrice(double preTaxPrice) {
		this.preTaxPrice = preTaxPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setProductsMap(Map<ProductDetails, Integer> productsMap) {
		this.productsMap = productsMap;
	}
	
	
	

}

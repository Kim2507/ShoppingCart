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
	
	@OneToMany(targetEntity=ProductDetails.class, cascade=CascadeType.ALL,mappedBy="cart")
	private List<ProductDetails> productsList;

	@Transient
	private static Map<ProductDetails,Integer> productsMap;
	
	public Cart() {
		productsMap = new HashMap<>();                                                                
	}
	
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
		// Add to List
		productsList.add(product);
		//Add to HashMap
		if (productsMap.containsKey(product)) {
			productsMap.replace(product, productsMap.get(product) + 1);
        } else {
        	productsMap.put(product, 1);
        } 
	}

    public void removeProduct(ProductDetails product) {
    	//Remove from list
    	productsList.remove(product); 
    	//Remove from hashmap 
    	 if (productsMap.containsKey(product)) {
             if (productsMap.get(product) > 1)
            	 productsMap.replace(product, productsMap.get(product) - 1);
             else if (productsMap.get(product) == 1) {
            	 productsMap.remove(product);
             }
         }
    }
	
	public Map<ProductDetails,Integer> getProductsMap(){
		return productsMap;
	}
	
	public double getPreTaxPrice() {
		getProductsMap().forEach((key,value)->{
			preTaxPrice += key.getPrice()*value;
		});
		return preTaxPrice;
	}
	
	public double getTotalPrice() {
		totalPrice= getPreTaxPrice()*(1+TAX_RATE);
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

	public List<ProductDetails> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<ProductDetails> productsList) {
		this.productsList = productsList;
	}
	
	
	

}

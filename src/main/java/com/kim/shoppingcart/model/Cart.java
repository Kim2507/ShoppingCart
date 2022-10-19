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
	private Long id;
	
	private final double TAX_RATE = 0.05;
	@Transient
	private final double PRODUCT_PRICE= 5.5;

	private double preTaxPrice;
	private double totalPrice;
	private int productCounter;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	
	
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=ProductDetails.class)
	private List<ProductDetails> productsList;
	
	@Transient
	private static Map<ProductDetails,Integer> productsMap;
	
	public Cart() {
		productCounter=0;
		productsMap = new HashMap<>();                                                                
	}
	
	public Cart(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public void addProduct(ProductDetails product) {
		getProductsList().add(product);
		productCounter++;
		product.setCart(this);
	}

    public void removeProduct(ProductDetails product) {
    	getProductsList().remove(product);
		product.setCart(this);
    }
	
	
	public Map<ProductDetails,Integer> getProductsMap(){
		return productsMap;
	}
	
	public double getPreTaxPrice() {
		// So far all products have same price 
		preTaxPrice = getProductCounter()*5.5;
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
		return user;
	}

	public void setUserID(User user) {
		this.user = user;
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

//	public ProductDetails getProduct() {
//		return product;
//	}
//
//	public void setProduct(ProductDetails product) {
//		this.product = product;
//	}

	public List<ProductDetails> getProductsList() {
		if(this.productsList==null) {
			this.productsList = new ArrayList<>();
		}
		return this.productsList;
	}

	public void setProductsList(List<ProductDetails> productsList) {
		this.productsList = productsList;
	}
	
	
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Cart) {
			Cart other = (Cart)obj;
			boolean sameId = (this.id==other.getId());
			boolean sameUserID = (this.user.equals(other.getUserID()));
			if(sameId && sameUserID) {
				return true;
			}
		}
		return false;
		
	}

	public int getProductCounter() {
		return productCounter;
	}

	public void setProductCounter(int productCounter) {
		this.productCounter = productCounter;
	}
	
	

}

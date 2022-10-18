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
	
//	@OneToOne(cascade=CascadeType.ALL)
//	private ProductDetails product;
	
//	@OneToMany(targetEntity=ProductDetails.class)
//	private List<ProductDetails> productsList;
	
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=ProductDetails.class)
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
		getProductsList().add(product);
		product.setCart(this);
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
		//preTaxPrice = product.getPrice();
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
	
	
	

}
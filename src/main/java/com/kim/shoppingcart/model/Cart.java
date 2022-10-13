package com.kim.shoppingcart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.*;
@Entity
@Table
public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private final double TAX_RATE = 0.05;

	private double preTax;
	private double total;
	
	@OneToMany(mappedBy="cart")
	private List<ProductDetails> productsList;

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

	public List<ProductDetails> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<ProductDetails> productsList) {
		this.productsList = productsList;
	}
	
	public void addProduct(ProductDetails product) {
		productsList.add(product);
	}

    public void removeProduct(ProductDetails product) {
    	productsList.remove(product);
    }
	
	public Map<ProductDetails,Integer> getProductMap(){
		productsMap = new HashMap<>();
		//productsList = list;
		for(ProductDetails p : getProductsList()) {
			Integer productCounter = productsMap.get(p);
			productsMap.put(p,(productCounter==null)?1:productCounter+1);
		}
		return productsMap;
	}
	
	public double getPreTax() {
		productsMap.forEach((key,value)->{
			preTax += key.getPrice()*value;
		});
		return preTax;
	}
	
	public double getTotal() {
		total= preTax*(1+TAX_RATE);
		return total;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", TAX_RATE=" + TAX_RATE + ", preTax=" + preTax + ", total=" + total
				 + ", productsMap=" + productsMap + "]";
	}
	
	
	

}

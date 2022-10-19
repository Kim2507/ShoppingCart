package com.kim.shoppingcart.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name="category")
public class Categories implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String categoryName;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=ProductDetails.class)
	private List<ProductDetails> productList;
	
	
	
	public List<ProductDetails> getProductList() {
		if(this.productList==null) {
			this.productList = new ArrayList<>();
		}
		return this.productList;
	}
	
	public void addProduct(ProductDetails product) {
		getProductList().add(product);
		product.setCategory(this);
	}

    public void removeProduct(ProductDetails product) {
    	getProductList().remove(product);
    	product.setCategory(this);
    }


}

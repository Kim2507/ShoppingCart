//package com.kim.shoppingcart.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.kim.shoppingcart.model.ProductDetails;
//import com.kim.shoppingcart.repository.ProductRepository;
//
//@RestController
//public class ProductController {
//	
//	@Autowired
//	ProductRepository productRepo;
//	
//	// Create 
//	@PostMapping("/products")
//	public ProductDetails addNewProduct(@RequestBody ProductDetails product) {
//		return productRepo.save(product);
//	}
//	
//	//Read 
//	@GetMapping("/products")
//	public List<ProductDetails> getAllProducts(){
//		return productRepo.findAll();
//	}
//	
//	//Update 
//	@PutMapping("/products/{id}")
//	ProductDetails updateProduct(@RequestBody ProductDetails newProduct,@PathVariable Integer id) {
//		return productRepo.findById(id).map(product->{
//			product.setName(newProduct.getName());
//			product.setDescription(newProduct.getDescription());
//			product.setPrice(newProduct.getPrice());
//			product.setStockQuantity(newProduct.getStockQuantity());
//			
//			return productRepo.save(product);
//		}).orElseGet(()->{
//			newProduct.setProductId(id);
//			return productRepo.save(newProduct);
//		});
//	}
//	
//	//Delete
//	@DeleteMapping("/products/{id}")
//	void deleteProduct(@PathVariable Integer id) {
//		productRepo.deleteById(id);
//	}
//}

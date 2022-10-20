package com.kim.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kim.shoppingcart.dto.UserDto;
import com.kim.shoppingcart.model.ProductDetails;
import com.kim.shoppingcart.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository productService;
	
	// Show the add product page
	@GetMapping("/new_product")
	public String showProductForm(Model model) {
		ProductDetails product = new ProductDetails();
		model.addAttribute("product", product);
		return "new_product";
	}

	// Create
	@PostMapping("/products")
	public String addNewProduct(@ModelAttribute("product") ProductDetails product, Model model) {
		productService.save(product);
		return "redirect:/products";
	}
	
	//Read 
	@GetMapping("/products")
	public String getAllProducts(Model model){
		List<ProductDetails> products = productService.findAll();
		model.addAttribute("products",products);
		return "product_list";
	}
	
	//Update 
	@PutMapping("/products/{id}")
	ProductDetails updateProduct(@RequestBody ProductDetails newProduct,@PathVariable Long id) {
		return productService.findById(id).map(product->{
			product.setName(newProduct.getName());
			product.setDescription(newProduct.getDescription());
			product.setPrice(newProduct.getPrice());
			product.setStockQuantity(newProduct.getStockQuantity());
			
			return productService.save(product);
		}).orElseGet(()->{
			newProduct.setProductId(id);
			return productService.save(newProduct);
		});
	}
	
	//Delete
	@GetMapping("/products/{id}")
	public String deleteProduct(@PathVariable(value="id") Long id) {
		productService.deleteById(id);
		return "redirect:/products";
	}
}

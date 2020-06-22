package com.thomasariyanto.simplecrudspring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thomasariyanto.simplecrudspring.dao.ProductRepo;
import com.thomasariyanto.simplecrudspring.entity.Product;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;

	@GetMapping
	public Iterable<Product> getProducts(){
		return productRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return productRepo.findById(id).get();
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		product.setId(0);
		return productRepo.save(product);
	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		productRepo.findById(product.getId()).get();
		return productRepo.save(product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable int id) {
		productRepo.findById(id).get();
		productRepo.deleteById(id);
	}
}

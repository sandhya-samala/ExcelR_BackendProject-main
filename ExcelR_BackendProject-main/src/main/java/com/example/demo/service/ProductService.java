package com.example.demo.service;

import java.util.List;

import com.example.demo.Product;

public interface ProductService {
	 String upsert(Product product);
	    Product getById(int id);
	    List<Product> getAllProducts();
	    String updateProduct(Product product);
	    String deleteById(int id);
	    List<Product> searchByName(String name);

}

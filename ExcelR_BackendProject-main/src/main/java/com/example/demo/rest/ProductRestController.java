package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRestController {
	@Autowired
	 private ProductService productService;
	
	 @PostMapping
	 public ResponseEntity<String> createProduct(@RequestBody Product product) {
	     String status = productService.upsert(product);
	     return new ResponseEntity<>(status, HttpStatus.CREATED);
	 }

	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProduct(@PathVariable int id) {
	        Product product = productService.getById(id);
	        return new ResponseEntity<>(product, HttpStatus.OK);
	    }

	    @GetMapping
	    public ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> products = productService.getAllProducts();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
	        product.setId(id); // Ensure the product ID is set to match the URL
	        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
	        String status = productService.deleteById(id);
	        return new ResponseEntity<>(status, HttpStatus.OK);
	    }
	    @GetMapping("/search")
	    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
	        List<Product> products = productService.searchByName(name);
	        if (products.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
}


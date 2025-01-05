package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Product;
import com.example.demo.repo.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
	 @Autowired
	    private ProductRepository productRepository;

	    @Override
	    public String upsert(Product product) {
	        productRepository.save(product);
	        return "Product saved successfully";
	    }

	    @Override
	    public Product getById(int id) {
	        Optional<Product> product = productRepository.findById(id);
	        return product.orElse(null);
	    }

	    @Override
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    @Override
	    public String deleteById(int id) {
	        if (productRepository.existsById(id)) {
	            productRepository.deleteById(id);
	            return "Product deleted successfully";
	        }
	        return "Product not found";
	    }
	    @Override
	    public String updateProduct(Product product) {
	        Optional<Product> existingProduct = productRepository.findById(product.getId());
	        if (existingProduct.isPresent()) {
	            productRepository.save(product); // Save the updated product
	            return "Product updated successfully";
	        } else {
	            return "Product not found"; // Return message if product does not exist
	        }
	    }
	    @Override
	    public List<Product> searchByName(String name) {
	        return productRepository.findByProductNameContainingIgnoreCase(name); // Using a repository method to search by name
	    }
	    
}

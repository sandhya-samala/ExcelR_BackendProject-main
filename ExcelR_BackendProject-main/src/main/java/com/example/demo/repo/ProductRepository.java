package com.example.demo.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable>{
	List<Product> findByProductNameContainingIgnoreCase(String name);
}

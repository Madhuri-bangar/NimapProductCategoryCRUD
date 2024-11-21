package com.nimap.category_product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nimap.category_product.Model.Categoryy;
import com.nimap.category_product.Model.Product;
import com.nimap.category_product.repository.CategoryRepository;
import com.nimap.category_product.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	 
	// 1. get all products with pagination
    public Page<Product> getAllProducts(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest); 
    }

	// 2.Create Product
	public Product createProduct(Product product) {
		Optional<Categoryy> category = categoryRepository.findById(product.getCategoryy().getId());
		if (category.isPresent()) {
			product.setCategoryy(category.get());
			return productRepository.save(product);
		}
		throw new RuntimeException("Category not found");
	}

	// 3.Get Product by ID
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	// 4.PUT - update product by id

	public String updateProduct(Long id, Product updatedProduct) {
		return productRepository.findById(id).map(product -> {
			product.setName(updatedProduct.getName());
			product.setPrice(updatedProduct.getPrice());
			product.setCategoryy(updatedProduct.getCategoryy());
			productRepository.save(product);
			return "Record updated successfully";
		}).orElse("Record not found");
	}

	//5. Delete Product by ID
	public boolean deleteProductById(Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

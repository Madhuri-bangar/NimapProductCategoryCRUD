package com.nimap.category_product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import com.nimap.category_product.Model.Product;
import com.nimap.category_product.service.ProductService;

@RestController
@RequestMapping("/api/products")

public class ProductController {
	@Autowired
	private ProductService productService;
	
	// 1.GET - Retrieve all products with pagination
    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page) {
        Page<Product> products = productService.getAllProducts(PageRequest.of(page, 5)); 
        return ResponseEntity.ok(products);
    }

	//2. POST - Create a new Product
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product newProduct = productService.createProduct(product);
		return ResponseEntity.ok(newProduct);
	}

	// 3.GET - Retrieve Product by ID
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Optional<Product> product = productService.getProductById(id);
		return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// 4.PUT - Update Product by ID
	@PutMapping("/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
		String result = productService.updateProduct(id, updatedProduct);
		if (result.equals("Record updated successfully")) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//5. DELETE - Delete Product by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
	    boolean isDeleted = productService.deleteProductById(id);
	    if (isDeleted) {
	        return ResponseEntity.ok("Record deleted successfully");
	    } else {
	        return ResponseEntity.status(404).body("Record not found");
	    }
	}
}

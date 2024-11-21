package com.nimap.category_product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.nimap.category_product.Model.Categoryy;
import com.nimap.category_product.service.CategoryService;

@RequestMapping("/api/categories")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// 1.GET all categories (with pagination)
	@GetMapping
	public Page<Categoryy> getAllCategories(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return categoryService.getAllCategories(page, size);
	}

	// 2.POST - Create a new category
	@PostMapping
	public ResponseEntity<Categoryy> createCategory(@RequestBody Categoryy category) {
		Categoryy newCategory = categoryService.createCategory(category);
		return ResponseEntity.ok(newCategory);
	}

//			3. @GetMapping("/getCategoryById/{id}")
	@GetMapping("/{id}")
	public Categoryy getCategoryById(@PathVariable Long id) {

		return categoryService.getCategoryById(id);

	}

	// 4. PUT - Update a category by ID
	@PutMapping("/{id}")
	public ResponseEntity<Categoryy> updateCategory(@PathVariable Long id, @RequestBody Categoryy updatedCategory) {
		Optional<Categoryy> category = categoryService.updateCategory(id, updatedCategory);
		return category.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// 5 DELETE - Delete category by id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
		return categoryService.deleteCategory(id) ? ResponseEntity.ok("Record deleted successfully")
				: ResponseEntity.status(404).body("Category not found");
	}
}

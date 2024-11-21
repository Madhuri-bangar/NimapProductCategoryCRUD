package com.nimap.category_product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nimap.category_product.Model.Categoryy;
import com.nimap.category_product.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Categoryy getCategoryById(Long id) {

		return categoryRepository.findById(id).get();
	}

	// Get all categories with pagination
	public Page<Categoryy> getAllCategories(int page, int size) {
		return categoryRepository.findAll(PageRequest.of(page, size));
	}

	// Create a new category
	public Categoryy createCategory(Categoryy category) {
		return categoryRepository.save(category);
	}

	// Update a category by ID
	public Optional<Categoryy> updateCategory(Long id, Categoryy updatedCategory) {
		return categoryRepository.findById(id).map(existingCategory -> {
			existingCategory.setName(updatedCategory.getName());
			existingCategory.setDescription(updatedCategory.getDescription());
			return categoryRepository.save(existingCategory);
		});
	}

	// Delete a category by ID

	public boolean deleteCategory(Long id) {
		if (categoryRepository.existsById(id)) {
			categoryRepository.deleteById(id);
			return true; // One record successfully deleted
		}
		return false; // No record deleted
	}

}

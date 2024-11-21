package com.nimap.category_product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.category_product.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@EntityGraph(attributePaths = "categoryy")
    Optional<Product> findById(Long id);
}

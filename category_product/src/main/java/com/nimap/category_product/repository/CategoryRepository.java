package com.nimap.category_product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nimap.category_product.Model.Categoryy;



public interface CategoryRepository extends JpaRepository<Categoryy, Long>  {
	@Query (value = "select * from categoryy where id like ?1",nativeQuery = true)
	 List <Categoryy> FindCategoryByID(Long  id);
	
	}



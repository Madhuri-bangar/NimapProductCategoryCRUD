package com.nimap.category_product.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // To handle lazy loading issues
public class Categoryy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;

	@OneToMany(mappedBy = "categoryy", cascade = CascadeType.ALL)
	// @JsonManagedReference
	@JsonIgnoreProperties("categoryy")// Avoid infinite recursion
	private List<Product> products;

	public Categoryy() {
		super();
	}

	public Categoryy(Long id, String name, String description, List<Product> products) {
		super();
	this.id = id;
		//id=id;
		this.name = name;
		this.description = description;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Categoryy [id=" + id + ", name=" + name + ", description=" + description + ", products=" + products
				+ "]";
	}

}
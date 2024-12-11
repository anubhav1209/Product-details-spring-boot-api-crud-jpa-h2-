package com.rest.api.services;

import java.util.List;

import com.rest.api.entity.Product;

public interface ProductServices {
	
	Product Create(Product product);
	Product update(Product product,int productId);
	void delete(int productId);
	Product getById(int productId);
	List<Product> getAll();
	
}

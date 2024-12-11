package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.entity.Product;
import com.rest.api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductServices{
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	
	public Product Create(Product product) {
		
		return this.productRepository.save(product);
	}
 
	
	public Product update(Product product, int productId) {
		
		Product product1=this.productRepository.findById(productId).orElseThrow(()-> new RuntimeException("product not found"));
		product1.setPrice(product.getPrice());
		product1.setName(product.getName());
		product1.setAbout(product.getAbout());
		Product save=this.productRepository.save(product1);
		return save;
	}

	public void delete(int productId) {
		Product product1=this.productRepository.findById(productId).orElseThrow(()-> new RuntimeException("product not found"));
		this.productRepository.delete(product1);
		
	}

	
	public Product getById(int productId) {
		Product product1=this.productRepository.findById(productId).orElseThrow(()-> new RuntimeException("product not found"));
		
		return product1;
	}

	
	public List<Product> getAll() {
		List<Product>all=this.productRepository.findAll();	
		return all;
	}

}

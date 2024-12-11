package com.rest.api.Contorller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entity.Product;
import com.rest.api.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@GetMapping("/")
	public Product Test() {
		 
		Product product=new Product();
		product.setAbout("this is tetsing product");
		product.setName("Phone");
		product.setPrice(80880);
		product.setId(100);
		
		return product;
	}
	@Autowired
	private ProductServices productService;
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product product1=this.productService.Create(product);
		return new ResponseEntity<>(product1,HttpStatus.CREATED);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable int productId ){
		Product product1=this.productService.update(product,productId);
		return new ResponseEntity<>(product1,HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable int productId ){
		this.productService.delete(productId);
		Map<String, String> message= Map.of("message","product deleted successfully");
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable int productId ){
		Product product1=this.productService.getById(productId);
		return new ResponseEntity<>(product1,HttpStatus.OK);
	}
	@GetMapping("/{productId}/")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> all=this.productService.getAll();
		return new ResponseEntity<>(all,HttpStatus.OK);
	}
	
	
	
	
}

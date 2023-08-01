package com.nagarro.exittest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exittest.dao.ProductRepo;
import com.nagarro.exittest.model.Product;
import com.nagarro.exittest.service.ProductService;


@RestController
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductService prodservice;
	
	
		@Autowired
		private ProductRepo prep;
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product products)
	{
		return this.prodservice.saveProduct(products);
	}
		
		
	@GetMapping("/getProducts")
	public List<Product> getAllProducts()
	{
		return this.prodservice.getProducts();
	}
	
	@GetMapping("/search")
	public List<Product> search(
			@RequestParam(name = "name",defaultValue = "") String name,
			@RequestParam(name = "code",defaultValue = "") String code,
			@RequestParam(name = "brand",defaultValue = "") String brand)
	{
		System.out.println(name + "   "+ code +"    " +brand);
		return this.prodservice.searchOperation(name, code,brand);
//		return this.prep.searchByFields(name, code,brand);

		
		
	}
	
	
	
	@GetMapping("getProduct/{productcode}")
	public Product getProductByCode(@PathVariable("productcode") String productCode)
	{

		return this.prodservice.getProductbyCode(productCode);
	}

}

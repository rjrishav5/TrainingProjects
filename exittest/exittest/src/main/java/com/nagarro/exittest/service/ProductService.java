package com.nagarro.exittest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.exittest.dao.ProductRepo;
import com.nagarro.exittest.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepo prodrepo;
	
	
	public Product saveProduct(Product p)
	{
		return this.prodrepo.save(p);
	}
	
	public List<Product> getProducts()
	{
		return this.prodrepo.findAll();
	}

	public List<Product> searchOperation(String name, String code, String brand) {
		
	  return this.prodrepo.searchByFields(name, code,brand);
	}
	

	public Product getProductbyCode(String productCode) {
		// TODO Auto-generated method stub
		Product products = this.prodrepo.findByProductCode(productCode);
		return products;
	}


}

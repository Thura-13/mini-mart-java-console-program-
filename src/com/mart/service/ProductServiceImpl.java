package com.mart.service;

import java.util.List;

import com.mart.dto.Product;
import com.mart.repo.ProductRepoImpl;

public class ProductServiceImpl implements ProductService {
	
	private static ProductServiceImpl instance;
	
	private ProductRepoImpl repoImpl;
	
	private ProductServiceImpl() {
		repoImpl = ProductRepoImpl.getInstance();
	}
	
	public static ProductServiceImpl getInstance() {
		
		if(instance == null) {
			return new ProductServiceImpl();
		}
		
		return instance;
	}

	@Override
	public List<Product> listAll() {
		return repoImpl.listAll();
	}

	@Override
	public void create(Product product) {
		repoImpl.create(product);
	}


	@Override
	public Product searchByCode(String code) {
		return repoImpl.searchByCode(code);
	}

	@Override
	public void delete(int id) {
		repoImpl.delete(id);
	}

	

}

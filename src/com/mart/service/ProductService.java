package com.mart.service;

import java.util.List;

import com.mart.dto.Product;

public interface ProductService {

	List<Product> listAll();
	void create(Product product);
	void delete(int id);
	Product searchByCode(String code );
}

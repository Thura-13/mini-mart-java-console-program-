package com.mart.repo;

import java.util.List;

import com.mart.dto.Product;

public interface ProductRepo {

	List<Product> listAll();
	void create(Product product);
	void delete(int id);
	Product searchByCode(String code );
}

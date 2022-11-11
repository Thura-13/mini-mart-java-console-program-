package com.mart.repo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.mart.dto.Product;

public class ProductRepoImpl implements ProductRepo{
	
	private static ProductRepoImpl instance;

	ArrayList<Product> list ;

	
	@SuppressWarnings("unchecked")
	private ProductRepoImpl() {

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("product.txt"))){
			list = (ArrayList<Product>) in.readObject();
		} catch (Exception e) {
			list = new ArrayList<Product>();
		}

	}
	public static ProductRepoImpl getInstance() {
		if(instance ==null) {
			return new ProductRepoImpl();
		}
		return instance;
	}

	@Override
	public List<Product> listAll() {
		
		return list;
		
	}

	@Override
	public void create(Product product) {
		
		try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("product.txt"))){
			list.add(product);
			ob.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public Product searchByCode(String code) {
		return list.stream().filter(p->p.getCode().equalsIgnoreCase(code))
				.findFirst().orElse(null);
	}

	@Override
	public void delete(int id) {
		list.remove(id-1);
		try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("product.txt"))){
			ob.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

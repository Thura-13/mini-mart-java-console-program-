package com.mart.controller;

import java.util.List;

import com.mart.dto.MartOperations;
import com.mart.dto.Product;
import com.mart.service.ProductServiceImpl;
import com.mart.utils.MartUtils;

public class MartController {
	
	private ProductServiceImpl service;
	
	public MartController() {
		service = ProductServiceImpl.getInstance();
	}
	
	public void run() {
		showOperation();
	}


	private void showOperation() {
		
		do {
			for (MartOperations opt : MartOperations.values()) {
				System.out.println(opt);
			} 
			
			MartOperations opt =
					MartOperations.values()[MartUtils.readInt("Select Operation :")-1];
			
			doOperation(opt);
				
		} while ("y".equalsIgnoreCase(MartUtils.readString("Do You Want To Again? Y/N")));
		
		System.out.println("Finished Program!!");
	}

	private void doOperation(MartOperations opt) {
		
		switch (opt) {
		case ShowAll:
			showAll();
			break;
		case Create:
			create();
			break;
		case Delete:
			delete();
			break;
		case SearchByCode:
			searchByCode();
			break;

		default:
			break;
		}
	}

	private void searchByCode() {
		
		Product p =service.searchByCode(MartUtils.readString("Enter Code :"));
		if(p == null) {
			System.out.println("Not Found!!!");
			System.out.println();
			return;
		}
		showHeader();
		System.out.printf("%-10s %-20s %-10s %-10s %-15s",p.getCode(),p.getName(),p.getPrice(),p.getStock(),p.getRemark());
		System.out.println();
		System.out.println();
		
	}

	private void delete() {
		int id = MartUtils.readInt("Enter id :");
		service.delete(id);
	}


	private void create() {
		
		String code = MartUtils.readString("Enter Code :");
		Product product = service.searchByCode(code);
		
		if(product == null) {
			List<Product> list = service.listAll();

			Product p = new Product();
			p.setId(list.size()+1);
			p.setCode(code);
			p.setName(MartUtils.readString("Enter Name :"));
			p.setPrice(MartUtils.readInt("Enter Price :"));
			p.setStock(MartUtils.readInt("Enter Stock :"));
			p.setRemark(MartUtils.readString("Enter Remark :"));
			service.create(p);
			
		}else {
			System.out.println("There is existing data!!");
			System.out.println();
		}
	}

	private void showAll() {
		
		showHeader();
		
		List<Product> listProduct = service.listAll();
		
		if(!listProduct.isEmpty()) {
			
			for(Product p : listProduct) {
				System.out.printf("%-10s %-10s %-20s %-10s %-10s %-15s\n",p.getId(), p.getCode(),p.getName(),p.getPrice(),p.getStock(),p.getRemark());
			}
			System.out.println();
			System.out.println();
		}else {
			System.out.println("There is no data!!!");
			System.out.println();
		}
		
	}

	private void showHeader() {
		String header = String.format("%-10s %-10s %-20s %-10s %-10s %-15s", "Id","Code","Name","Price","Stock","Remark");
		
		System.out.println(header);
		
		for(int i=0;i < header.length();i++) {		
			System.out.print("-");
		}
		
		System.out.println();
	}


}

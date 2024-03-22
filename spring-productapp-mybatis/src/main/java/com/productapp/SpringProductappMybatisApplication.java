package com.productapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappMybatisApplication implements CommandLineRunner{
	@Autowired
	IProductService service;
	public static void main(String[] args) {
		SpringApplication.run(SpringProductappMybatisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Product product=new Product("Galaxy S 24","Samsung",123000,"electronics");
//		service.addProduct(product);
//		service.updateProduct(5, 1200);
//		service.deleteProduct(5);
		
//		System.out.println(service.getById(2));
		
//		List<Product> productList=service.getAll();
//		for (Product product : productList) {
//			System.out.println(product);
//		}
//		List<Product> productList=service.getByBrand("Samsung");
//		for (Product product : productList) {
//			System.out.println(product);
//		}
//		List<Product> productList=service.getByCategoryAndPrice("electronics",32010);
//		for (Product product : productList) {
//			System.out.println(product);
//		}
//		List<Product> productList=service.getByLesserPrice(200000);
//		for (Product product : productList) {
//			System.out.println(product);
//		}
		
	}

}

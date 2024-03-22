package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	IProductRepository repository;
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		repository.addProduct(product);
	}

	@Override
	public void updateProduct(int productId,double fees) {
		// TODO Auto-generated method stub
		repository.updateProduct(productId,fees);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		repository.deleteProduct(productId);
	}

	@Override
	public Product getById(int productId) throws ProductNotFoundException {
		return repository.findById(productId);
		
	}

	@Override
	public List<Product> getAll() {
		return repository.findAll();
		
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException {
		
		return repository.findByBrand(brand);
	}

	@Override
	public List<Product> getByLesserPrice(double price) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return repository.findByLesserPrice(price);
	}

	@Override
	public List<Product> getByCategoryAndPrice(String category, double price) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return repository.findByCategoryAndPrice(category, price);
	}

}

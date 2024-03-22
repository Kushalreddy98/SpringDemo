package com.productapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
@Mapper
public interface IProductRepository {
	@Insert("insert into Product(product_name,brand,price,category) values(#{policyName},#{brand},#{price},#{category})")
	void addProduct(Product product);
	@Update("update Product set price=#{price} where product_id=#{productId}")
	void updateProduct(int productId,double price);
	@Delete("delete from Product where product_id=#{productId}")
	void deleteProduct(int productId);
	@Select("select * from Product where product_id=#{productId}")
	Product findById(int productId) throws ProductNotFoundException;
	@Select("select * from Product")
	List<Product> findAll();
	@Select("select * from Product where brand=#{brand}")
	List<Product> findByBrand(String brand) throws ProductNotFoundException;
	@Select("select * from Product where price<#{price}")
	List<Product> findByLesserPrice(double price) throws ProductNotFoundException;
	@Select("select * from Product where category=#{category} and price=#{price}")
	List<Product> findByCategoryAndPrice(String category,double price) throws ProductNotFoundException;
}

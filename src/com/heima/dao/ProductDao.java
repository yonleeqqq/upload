package com.heima.dao;

import java.util.List;

import com.heima.bean.Product;

public interface ProductDao {
	void save(Product product);
	List<Product> getAllProduct();
	Product getProductById(int id);
	void update(Product product);

}

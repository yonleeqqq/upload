package com.heima.service;

import java.util.List;

import com.heima.bean.Product;
import com.heima.dao.ProductDao;
import com.heima.dao.impl.ProductDaoImpl;

public class ProductService {
	private ProductDao dao = new ProductDaoImpl();
	public void save(Product product){
		dao.save(product);
	}
	public List<Product> getAll(){
		return dao.getAllProduct();
	}
	public Product getProductById(int id){
		return dao.getProductById(id);
	}
	public void update(Product product){
		dao.update(product);
	}
	
}

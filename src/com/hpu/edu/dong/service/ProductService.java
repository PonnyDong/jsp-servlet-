package com.hpu.edu.dong.service;

import java.sql.SQLException;
import java.util.List;

import com.hpu.edu.dong.domain.Category;
import com.hpu.edu.dong.domain.Product;

import com.hpu.edu.dong.dao.ProductDao;

public class ProductService {

	public Product findProductByPid(String pid) {
		ProductDao dao=new ProductDao();
		Product product=null;
		try {
			product = dao.findProductByPid(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
		// TODO Auto-generated method stub
		
	}
	//获得优惠商品
	public List<Product> findDiscProductList() {
		// TODO Auto-generated method stub
		ProductDao dao=new ProductDao();
		List<Product> discProductList=null;
		try {
			discProductList=dao.findDiscProductList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return discProductList;
		
	}
	
	
	
}

package com.hpu.edu.dong.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hpu.edu.dong.domain.Category;
import com.hpu.edu.dong.domain.Product;
import com.hpu.edu.dong.utils.DataSourceUtils;

public class ProductDao {
	//获得促销商品
	public List<Product> findDiscProductList() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from [product] where is_discount=?";
		return runner.query(sql, new BeanListHandler<Product>(Product.class),1);
	}
	
	public Product findProductByPid(String pid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from [product] where pid=? ";
		return runner.query(sql, new BeanHandler<Product>(Product.class), pid);
	}
	
	
}

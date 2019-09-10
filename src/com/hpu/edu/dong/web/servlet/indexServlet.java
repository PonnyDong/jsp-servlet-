package com.hpu.edu.dong.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpu.edu.dong.domain.Category;
import com.hpu.edu.dong.domain.Product;
import com.hpu.edu.dong.service.ProductService;


public class indexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service=new ProductService();
		//准备优惠商品----List<Product>
		List<Product> discProductList= service.findDiscProductList();
		//准备分类数据
		request.setAttribute("discProductList", discProductList);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		//转发到index.jsp中
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
package com.hpu.edu.dong.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	//可以用list集合，但是不利于后期增删改查
	//该购物车中存储的n个购物对象
	private Map<String,CartItem> cartItems=new HashMap<String,CartItem>();
	//商品的总计
	private double total;
	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}

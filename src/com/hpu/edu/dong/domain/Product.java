package com.hpu.edu.dong.domain;

import java.util.Date;

public class Product {

	private String pid;
	private String pname;
	private double price;
	private double disc_price;
	private String pimage;
	private Date pdate;
	private int is_discount;
	private String pdesc;
	private int pflag;
	private Category category;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public double getDisc_price() {
		return disc_price;
	}
	public void setDisc_price(double disc_price) {
		this.disc_price = disc_price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getIs_discount() {
		return is_discount;
	}
	public void setIs_discount(int is_discount) {
		this.is_discount = is_discount;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getPflag() {
		return pflag;
	}
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
}

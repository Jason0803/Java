package com.store.vo;
import com.store.util.MyDate;

public class Product {
	private String maker;
	private String model;
	private int serialNo;
	private int price;
	private MyDate startDate;
	
	public Product(int serialNo, String maker, String model, int price, MyDate startDate) {
		this.maker = maker;
		this.model = model;
		this.serialNo = serialNo;
		this.price = price;
		this.startDate = startDate;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MyDate getStartDate() {
		return startDate;
	}

	public void setStartDate(MyDate startDate) {
		this.startDate = startDate;
	}
	
	
	
}

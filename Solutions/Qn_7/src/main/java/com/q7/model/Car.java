package com.q7.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


public class Car {
	@Min(value=1)
	private int id;
	
	@Size(max=20)
	private String name;
	
	@Min(value=1)
	private int price;
	
	private String reason;
	
	public Car() {
		super();
	}


	
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", reason=" + reason + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getReason() {
		return reason;
	}



	public void setReason(String reason) {
		this.reason = reason;
	}



	public static String[] getFields() {
	  return new String[] {"id", "name", "price","reason"};
	}
	
	

}

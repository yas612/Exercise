package com.q4.model;

public class Bike {
	
	
	@Override
	public String toString() {
		return "Bike [id=" + id + ", name=" + name + ", speed=" + speed + "]";
	}
	private Integer id;
	private String name;
	private Integer speed;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	
	
	
	

}

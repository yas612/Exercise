package com.q12.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pencil")
public class Pencil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int count;
	
	public Pencil() {
		
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Pencil(int id, String name, int count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Pencil [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	
	

}

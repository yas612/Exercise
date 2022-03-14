package com.q8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

@Entity
@Table(name = "movies")
public class Movie {

	 @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	 
	 
	 @Column(name="name")
	private String name;
	 
	 @Column(name="rating")
	private Integer rating;
	
	public Movie() {
		
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Movie(int id, String name, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", rating=" + rating + "]";
	}
	
	
}

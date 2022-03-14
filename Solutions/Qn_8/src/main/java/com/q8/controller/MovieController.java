package com.q8.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.q8.exception.MovieRequestException;
import com.q8.model.Movie;
import com.q8.service.MovieServiceImpl;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieServiceImpl service;
	
	@RequestMapping(path="/add",method=RequestMethod.POST
			,produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public String add(@RequestBody Movie movie) {
		service.addMovie(movie);
		return "Movie added with id "+movie.getId();
		
	}
	
	@RequestMapping(path="/findall",method=RequestMethod.GET
			,produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	    public ResponseEntity<List<Movie>> loadMyMovies() {
		List<Movie> allmovies = service.getAllMovies();
		return new ResponseEntity<List<Movie>>(allmovies, HttpStatus.OK);
	       
	    }
	 
	@RequestMapping(path="/{id}",method=RequestMethod.GET
			,produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	   public Optional<Movie> getMovie(@PathVariable("id") int id) throws MovieRequestException
		 {
		      
			 return service.getmovie(id);
			
		 }
}

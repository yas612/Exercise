package com.q8.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.q8.exception.MovieRequestException;
import com.q8.model.Movie;
import com.q8.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieRepository repository;

	private static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);
	@Override
	public Movie addMovie(Movie movie) {
		
		log.info("The movie "+movie.getName() + " is added successfully");
		
		return repository.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		log.info("The list of movies are listed below");
		
		return repository.findAll();
	}

	@Override
	public Optional<Movie> getmovie(int id) {

		return Optional.of(repository.findById(id)
				 .orElseThrow( () -> new MovieRequestException("movie not found with this id ::")));
	}

}

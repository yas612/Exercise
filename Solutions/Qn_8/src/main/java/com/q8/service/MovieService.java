package com.q8.service;

import java.util.List;
import java.util.Optional;

import com.q8.model.Movie;

public interface MovieService {

	public Movie addMovie(Movie movie);
	public List<Movie> getAllMovies();
	public Optional<Movie> getmovie(int id);
}

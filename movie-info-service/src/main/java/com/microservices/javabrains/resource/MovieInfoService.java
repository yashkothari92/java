package com.microservices.javabrains.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.javabrains.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoService {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		//return Arrays.asList(
		return new Movie(movieId, "Batman Begins", "1st movie of Dark Knight Trilogy")		;	
		//);
	}
}

package com.microservices.javabrains.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.javabrains.model.Rating;

@RestController
@RequestMapping("/ratingsData")
public class RatingsResource {

	@RequestMapping("/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
}

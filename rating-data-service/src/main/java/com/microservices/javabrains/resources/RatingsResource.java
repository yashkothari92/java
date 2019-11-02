package com.microservices.javabrains.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.javabrains.model.Rating;
import com.microservices.javabrains.model.UserRating;

@RestController
@RequestMapping("/ratingsData")
public class RatingsResource {
	
	@Autowired
	UserRating userRating;

	@RequestMapping("/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("MJ01", 4),
				new Rating("YB9T", 5)
		);
		userRating.setRatings(ratings);
		return userRating;
	}
}

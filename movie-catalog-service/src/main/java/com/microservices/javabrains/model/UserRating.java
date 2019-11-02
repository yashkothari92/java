package com.microservices.javabrains.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserRating {

	private List<Rating> ratings;

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
}

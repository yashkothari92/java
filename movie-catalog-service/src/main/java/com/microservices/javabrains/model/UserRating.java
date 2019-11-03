package com.microservices.javabrains.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserRating {

	private List<Rating> ratings;
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
}

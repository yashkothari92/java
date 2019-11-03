package com.microservices.javabrains.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.microservices.javabrains.model.Rating;
import com.microservices.javabrains.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class UserRatingService {
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		return restTemplate.getForObject("http://ratings-data-service/ratingsData/users/"+userId, UserRating.class);
	}
	
	public UserRating getFallbackUserRating(@PathVariable("userId") String userId) {
		UserRating userRating = new UserRating();
		userRating.setUserId(userId);
		userRating.setRatings(Arrays.asList(new Rating("0", 0)));
		return userRating;
	}
	
}

package com.microservices.javabrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.microservices.javabrains.model.CatalogItem;
import com.microservices.javabrains.model.Movie;
import com.microservices.javabrains.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class MovieInfoService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	}
	
	public CatalogItem getFallbackCatalogItem(Rating rating) {
		return new CatalogItem("Movie not found", "Application down for now", rating.getRating());
	}

}

package com.microservices.javabrains.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservices.javabrains.model.CatalogItem;
import com.microservices.javabrains.model.Movie;
import com.microservices.javabrains.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {
		// step 1: get all rated movieID
		List<Rating> ratings = Arrays.asList(
				new Rating("MJ01", 4),
				new Rating("YB9T", 5)
		);

		// step 2: for each movieId, call movie-info-service to get details
		return ratings.stream().map(rating -> {
			// Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			// return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
			 
			 Movie movie = webClientBuilder
								 	.build()
								 	.get()
								 	.uri("http://localhost:8082/movies/\"+rating.getMovieId()")
								 	.retrieve()
								 	.bodyToMono(Movie.class)
								 	.block();
			 return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		})
		.collect(Collectors.toList()); 	// step 3: put them all together		
		
		/**
		 * return Collections.singletonList( 
		 * new CatalogItem("Dark Knight", "penultimate movie of Dark Knight Trilogy", 5) );
		 */
	}
}

package com.microservices.javabrains.resources;

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
import com.microservices.javabrains.model.UserRating;

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
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsData/users/"+userId, UserRating.class);
		
		// step 2: for each movieId, call movie-info-service to get details
		return ratings.getRatings().stream().map(rating -> {
			 Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);

			 // step 3: put them all together
			 return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		})
		.collect(Collectors.toList()); 			
		
		/**
		 * return Collections.singletonList( 
		 * new CatalogItem("Dark Knight", "penultimate movie of Dark Knight Trilogy", 5) );
		 */
	}
}
/**
Movie movie = webClientBuilder
	.build()
	.get()
	.uri("http://localhost:8082/movies/\"+rating.getMovieId()")
	.retrieve()
	.bodyToMono(Movie.class)
	.block();
return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
*/
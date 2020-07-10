package com.movie.catalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.model.CatalogItem;
import com.movie.catalog.model.Movie;
import com.movie.catalog.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieInfoService {
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),/*Return fallback Method after the timeout*/
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),/*consider the past 5 request, to trigger fallback on max failures*/
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"), /*consider requests in percentage to trigger fallback*/
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),/*sleep circuitBreak before it pickup again*/
	})
	public CatalogItem getCatalogItem(Rating r) {
		Movie movie = restTemplate.getForObject("http://movie-information-service/movie/"+r.getMovieId(), Movie.class); 
		  return new CatalogItem(movie.getMovieName(),movie.getMovieId(), r.getRating());
	}
	
	private CatalogItem getFallbackCatalogItem(Rating r) {
		return new CatalogItem("Movie not found", "", r.getRating());
	}
	
}

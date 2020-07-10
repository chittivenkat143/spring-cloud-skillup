package com.movie.catalog.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.model.CatalogItem;
import com.movie.catalog.model.Movie;
import com.movie.catalog.model.Rating;
import com.movie.catalog.model.UserRatings;
import com.movie.catalog.services.MovieInfoService;
import com.movie.catalog.services.UserRatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalogs")
@RefreshScope
public class CatalogController {
	
	@Value("${msg:DefaultValue}")
	private String strMsgFromConfigServer;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MovieInfoService movieInfoService;
	
	@Autowired
	UserRatingService userRatingService;
	
	@RequestMapping(value = "/catalog/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		  UserRatings userRatings = userRatingService.getUserRating(userId); 
		  return userRatings.getRatings().stream()
				  .map(r -> movieInfoService.getCatalogItem(r))
				  .collect(Collectors.toList());
	}


	@RequestMapping("/hi")
	public String sayHi() {
		return "Hello..CatalogController It s working..\n" + strMsgFromConfigServer;
	}

}

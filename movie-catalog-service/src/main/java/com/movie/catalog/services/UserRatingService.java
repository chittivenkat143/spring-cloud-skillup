package com.movie.catalog.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.model.Rating;
import com.movie.catalog.model.UserRatings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingService {
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRatings getUserRating(String userId) {
		return restTemplate.getForObject("http://movie-rating-service/rating/user/"+userId,UserRatings.class);
	}
	
	private UserRatings getFallbackUserRating(String userId) {
		UserRatings ur = new UserRatings();
		ur.setUserId(userId);
		ur.setRatings(Arrays.asList(new Rating("0", 0)));
		return ur ;
	}
	
}

package com.rating.data.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.data.model.Rating;
import com.rating.data.model.UserRatings;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Value("${msg : Hello Default}")
	private String strMsgFromConfigServer;
	
	@RequestMapping("/movie/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 3);
	}
	

	@RequestMapping("/user/{userId}")
	public UserRatings getUserRating(@PathVariable("userId") String userId) {
		UserRatings ratings = new UserRatings();
		ratings.init(userId);
		return ratings;
	}
	
	@RequestMapping("/hi")
	public String sayHi() {
		return "Hello..RatingController It s working..\n" + strMsgFromConfigServer;
	}
}

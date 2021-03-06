package com.movie.catalog.model;

import java.util.Arrays;
import java.util.List;

public class UserRatings {
	private String userId;
	private List<Rating> ratings;
	
	public UserRatings() {
		super();
	}
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
	public void init(String userId) {
		this.setUserId(userId);
		this.setRatings(Arrays.asList(
			new Rating("100", 3),
			new Rating("200", 4)
		));
	}
	
	
}

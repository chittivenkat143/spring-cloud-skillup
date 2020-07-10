package com.movie.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie.info.model.Movie;
import com.movie.info.model.MovieSummary;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Value("${api_key}")
	private String api_key;
	
	@Value("${msg : Hello Default}")
	private String strMsgFromConfigServer;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + api_key, MovieSummary.class);
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}
	
	@RequestMapping("/hi")
	public String sayHi() {
		return "Hello..MovieController It s working..\n" + strMsgFromConfigServer;
	}

}
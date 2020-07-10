package com.movie.catalog.model;

public class Movie {
	private String movieId;
	private String movieName;
	private String movieOverView;
	
	public Movie() {
		super();
	}
	public Movie(String movieId, String movieName,String movieOverView) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieOverView = movieOverView;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieOverView() {
		return movieOverView;
	}
	public void setMovieOverView(String movieOverView) {
		this.movieOverView = movieOverView;
	}
	
}

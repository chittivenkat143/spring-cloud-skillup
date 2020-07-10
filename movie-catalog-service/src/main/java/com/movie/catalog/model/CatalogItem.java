package com.movie.catalog.model;

public class CatalogItem {
	
	private String movieName;
	private String movieInfo;
	private int movieRating;
	
	
	public CatalogItem() {
		super();
	}
	public CatalogItem(String movieName, String movieInfo, int movieRating) {
		super();
		this.movieName = movieName;
		this.movieInfo = movieInfo;
		this.movieRating = movieRating;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}
	public int getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}
	@Override
	public String toString() {
		return "CatalogItem [movieName=" + movieName + ", movieInfo=" + movieInfo + ", movieRating=" + movieRating
				+ "]";
	}
	
	
}

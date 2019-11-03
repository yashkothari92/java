package com.microservices.javabrains.model;

public class MovieSummary {

	private int id;
	private String original_title;
	private String overview;
	private String imdb_id;
	
	public MovieSummary() {
		
	}

	public MovieSummary(int id, String original_title, String overview, String imdb_id) {
		super();
		this.id = id;
		this.original_title = original_title;
		this.overview = overview;
		this.imdb_id = imdb_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}

}

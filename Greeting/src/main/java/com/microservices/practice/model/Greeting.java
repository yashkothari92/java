package com.microservices.practice.model;

public class Greeting {

	private int id;
	private String contents;

	public Greeting(int id, String contents) {
		super();
		this.id = id;
		this.contents = contents;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

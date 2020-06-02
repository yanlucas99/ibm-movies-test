package com.example.ibmtest;

import java.io.Serializable;

public class Movies implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 348760439690682519L;

	private String Title;
	private int Year;
	private String imdbID;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

}

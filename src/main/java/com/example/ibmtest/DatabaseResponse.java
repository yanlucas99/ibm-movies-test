package com.example.ibmtest;

import java.util.LinkedList;

public class DatabaseResponse {
	private String page;
	private int per_page;
	private int total;
	private int total_pages;
	private LinkedList<Movies> data;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public LinkedList<Movies> getData() {
		return data;
	}

	public void setData(LinkedList<Movies> data) {
		this.data = data;
	}

}

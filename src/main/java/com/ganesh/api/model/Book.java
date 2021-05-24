package com.ganesh.api.model;

/**
 * @Project: books-ws
 * @Author: Ganesh
 * @Date: May 24, 2021
 */

public class Book {
	
	private String bookId;
	private String isbn;
	private String title;
	private String publisher;
	private String dataPublished;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String bookId, String isbn, String title, String publisher, String dataPublished) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.dataPublished = dataPublished;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDataPublished() {
		return dataPublished;
	}

	public void setDataPublished(String dataPublished) {
		this.dataPublished = dataPublished;
	}
	
	

}

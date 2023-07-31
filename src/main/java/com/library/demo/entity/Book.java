package com.library.demo.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Book_details")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long book_id;
	
	@Column(name="book_name")
	private String name;
	
	@Column(name="author_name")
	private String author;
	
	@Column(name="book_price")
	private String price;
	
	public Book() {}
	
	public Book(Long book_id, String name, String author, String price) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}



	
}

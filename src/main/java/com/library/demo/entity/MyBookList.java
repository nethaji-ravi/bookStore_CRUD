package com.library.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MyBookList")
public class MyBookList {
	
	@Id
	private Long id;
	
	@Column(name="book_name")
	private String name;
	
	@Column(name="author_name")
	private String author;
	
	@Column(name="book_price")
	private String price;
	
	public MyBookList() {}
	
	public MyBookList(Long id, String name, String author, String price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "MyBookList [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	
	

}

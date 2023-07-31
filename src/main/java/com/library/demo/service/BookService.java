package com.library.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.entity.Book;
import com.library.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository book_repo;
	
	public void save(Book b) {
		book_repo.save(b);
	}
	
	public List<Book> getAllBook(){
		return book_repo.findAll();
	}
	
	public Book getBookById(long id) {
		return book_repo.findById(id).get();
	}
	
	public void deleteAvailableBook(long id) {
		book_repo.deleteById(id);
	}
	
	public List<Book> login(long id,String name) {
		return book_repo.login(id, name);
		
	}
}

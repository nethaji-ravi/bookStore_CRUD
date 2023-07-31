package com.library.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.entity.MyBookList;
import com.library.demo.repository.MyBookRepository;

import jakarta.transaction.Transactional;

@Service
public class MyBookListService {

	@Autowired
	private MyBookRepository mybook_repo;
	
	public void saveMyBooks(MyBookList mybook) {
		mybook_repo.save(mybook);
	}
	
	public List<MyBookList> getAllBooks() {
		return mybook_repo.findAll();
	}
	
	@Transactional
	public void deleteById(long id) {
		mybook_repo.deleteById(id);
	}
}

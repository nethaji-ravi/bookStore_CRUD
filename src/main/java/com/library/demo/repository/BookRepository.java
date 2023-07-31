package com.library.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.demo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

	@Query("SELECT a FROM Book a WHERE a.book_id = :id AND a.author = :name")
	List<Book> login(long id,String name);
}

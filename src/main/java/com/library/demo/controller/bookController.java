package com.library.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.library.demo.entity.Book;
import com.library.demo.entity.MyBookList;
import com.library.demo.service.BookService;
import com.library.demo.service.MyBookListService;

@Controller
public class bookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService bookService;
	

	@GetMapping("/home")
	public String home() {
//		System.out.println("loginin hhhh");
//		System.out.println(service.login(1, "dss"));
		return "home";
	}
	
	@GetMapping("/bookRegister")
	public String bookRegister() {
		
		return "bookRegister";
	}
	
	@GetMapping("/availableBooks")
	public ModelAndView availableBooks() {
		System.out.println("available Books");
		List<Book> list=service.getAllBook();
		ModelAndView mv=new ModelAndView();
		mv.addObject("book",list);
		mv.setViewName("availableBooks");
		System.out.println(list);
		for(Book book:list) System.out.println(book);
		return mv;
	}
	
	@GetMapping("/myBooks")
	public ModelAndView myBooks() {
		List<MyBookList> list=bookService.getAllBooks();
		ModelAndView mv=new ModelAndView();
		mv.addObject("book",list);
		mv.setViewName("myBooks");
		System.out.println(list);
		return mv;
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/home";
	}
	
	@RequestMapping("/mylist/{id}")
	public String myBooklist(@PathVariable("id") int id) {
		Book book=service.getBookById(id);
		MyBookList mb=new MyBookList(book.getBook_id(),book.getName(),book.getAuthor(),book.getPrice());
		bookService.saveMyBooks(mb);
		return "redirect:/myBooks";
	}
	
	@RequestMapping("/deleteAvailableBook/{id}")
	public String deleteAvailableBook(@PathVariable("id") long id) {
		service.deleteAvailableBook(id);
		return "redirect:/availableBooks";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") long id,Model model) {
		Book b=service.getBookById(id);
		System.out.println("editbook aaaa");
		System.out.println(b);
		model.addAttribute("book",b);
		return "editBook";
	}
}

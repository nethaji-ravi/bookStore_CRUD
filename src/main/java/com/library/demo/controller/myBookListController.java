package com.library.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.library.demo.service.MyBookListService;

@Controller
public class myBookListController {
	
	@Autowired
	private MyBookListService myBook;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") long id) {
		myBook.deleteById(id);
		return "redirect:/myBooks";
	}

}

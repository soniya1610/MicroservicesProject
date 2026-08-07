 package com.soniya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soniya.entity.Author;
import com.soniya.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorService bookService;
	
	@RequestMapping(value = {"/","/home"})
	public String home() {
		return "Welcome to Author Webservice!";
	}
	@GetMapping("/searchAuthors/{name}")
	public List<Author> searchAuthors(@PathVariable String name) {
		return bookService.getAuthorsByName(name);
	}
	@GetMapping("/getAuthors")
	public List<Author> getAuthors() {
		return bookService.getAuthors();
	}
}
package com.soniya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soniya.dto.BookDTO;
import com.soniya.entity.Author;
import com.soniya.entity.Book;
import com.soniya.service.BookService;


@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = {"/","/home"})
	public String home() {
		return "Welcome to Book Webservice!";
	}
	@PostMapping("/addBook")
	public boolean addBook(
			@RequestParam String name,
			@RequestParam int price,
			@RequestParam String aname,
			@RequestParam int age) {
		Book book=new Book();
		book.setName(name);
		book.setPrice(price);
		Author a=new Author();
		a.setName(aname);
		a.setAge(age);
		book.setAuthor(a);
		boolean r=bookService.saveBook(book);
		return r;
	}
	@PostMapping("/saveBook")
	public boolean saveBook(@RequestBody Book book) {
		boolean r=bookService.saveBook(book);
		return r;
	}
	@GetMapping("/searchBook/{name}")
	public Book searchBook(@PathVariable String name) {
//		System.out.println("API Hit hui re!");
		return bookService.getBookByName(name);
	}
	@GetMapping("/searchBooks/{name}")
	public List<Book> searchBooks(@PathVariable String name) {
		return bookService.getBooksByName(name);
	}
	@GetMapping("/books")
	public List<Book> books() {
		return bookService.getAllBooks();
	}
	@GetMapping("/dto_books")
	public List<BookDTO> dtoBooks() {
		return bookService.getDTOBooks();
	}
	@DeleteMapping("/deleteBook/{id}")
	public boolean deleteBook(@PathVariable Long id) {
		return bookService.deleteBook(id);
	}
	@PutMapping("updateBook/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
		return bookService.updateBook(id,book);
	}
}





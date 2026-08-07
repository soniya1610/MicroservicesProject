package com.soniya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soniya.dto.BookDTO;
import com.soniya.entity.Book;
import com.soniya.repo.AuthorRepo;
import com.soniya.repo.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private AuthorRepo authorRepo;
	
	public boolean saveBook(Book book) {
		Book b=bookRepo.findByName(book.getName());
		if(b==null) {
			authorRepo.save(book.getAuthor());
			bookRepo.save(book);
			return true;
		}else {
			return false;
		}
	}

	public Book getBookByName(String name) {
		return bookRepo.findByName(name);
	}

	public List<Book> getBooksByName(String name) {
		return bookRepo.findAllByNameContains(name);
//		return bookRepo.findAllByName("%"+name+"%");
	}

	public List<Book> getAllBooks() {
//		return bookRepo.findAllByOrderByPrice();
		return bookRepo.findAllByOrderByPriceDesc();
//		return bookRepo.findAll();
	}

	public List<BookDTO> getDTOBooks() {
		return bookRepo.getDtoBooks();
	}

	public boolean deleteBook(Long id) {
		Book b=bookRepo.findById(id).orElse(null);
		if(b==null) {
			return false;
		}else {
			bookRepo.deleteById(id);
			return true;
		}
	}

	public Book updateBook(Long id, Book book) {
		Book b=bookRepo.findById(id).orElse(null);
		if(b!=null) {
			b.setName(book.getName());
			b.setPrice(book.getPrice());
			b.getAuthor().setName(book.getAuthor().getName());
			b.getAuthor().setAge(book.getAuthor().getAge());
			bookRepo.save(b);
		}
		return b;
	}
}
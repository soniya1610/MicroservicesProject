package com.soniya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soniya.entity.Author;
import com.soniya.repo.AuthorRepo;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepo authorRepo;
	
	public List<Author> getAuthorsByName(String name) {
		return authorRepo.findAllByNameContains(name);
	}

	public List<Author> getAuthors() {
		return authorRepo.findAll();
	}
	
	
}
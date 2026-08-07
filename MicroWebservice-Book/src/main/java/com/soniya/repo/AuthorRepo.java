package com.soniya.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soniya.entity.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

	List<Author> findAllByNameContains(String name);
	
}
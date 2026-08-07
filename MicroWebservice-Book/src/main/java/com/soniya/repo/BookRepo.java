package com.soniya.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.soniya.dto.BookDTO;
import com.soniya.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

	Book findByName(String name);

	@Query("select b from Book b where b.name like :n")
	List<Book> findAllByName(@Param("n") String name);
	
	List<Book> findAllByNameContains(String name);

	@Query("select new com.soniya.dto.BookDTO(b.id, b.name,b.price) from Book b")
	List<BookDTO> getDtoBooks();
	
	List<Book> findAllByOrderByPrice();

	List<Book> findAllByOrderByPriceDesc();
	
	
}
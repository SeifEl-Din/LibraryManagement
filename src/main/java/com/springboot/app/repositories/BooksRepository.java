package com.springboot.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.entities.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>  {

	List<Books> findAll();
	
		
	


}

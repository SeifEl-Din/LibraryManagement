package com.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.entities.Books;
import com.springboot.app.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BooksController {

	@Autowired
    private BookService bookService;
	
	
	@GetMapping
	public ResponseEntity<List<Books>>getAllBooks(){
		
		List<Books> books = bookService.getAllBooks();
		return ResponseEntity.ok().body(books);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Books> getBookById(@PathVariable Long id) {
		
		Books book = bookService.getBookById(id);
		return ResponseEntity.ok().body(book);
		
	}
	
	@PostMapping("/addbook")
	public ResponseEntity<Books> addBook(@RequestBody Books book){
		
		Books addedBook = bookService.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Books> updateBook(@PathVariable Long id, @RequestBody Books updatedBook){
		Books book = bookService.updateBook(id, updatedBook);
		
		if (book == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(book);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Books> deleteBook(@PathVariable Long id){
		
		boolean deleted = bookService.deleteBook(id);
		
		if(!deleted) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();

		
	}
	
}

package com.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.entities.Books;
import com.springboot.app.repositories.BooksRepository;

@Service
public class BookService {
	
	@Autowired
    private BooksRepository booksRepository;

	public List<Books> getAllBooks() {
		 List<Books> books = booksRepository.findAll();
	        
	        // Log after fetching books
	        System.out.println("Fetched " + books.size() + " books from the database.");
	        
	        return books;
	}

	public Books getBookById(Long id) {
		return booksRepository.findById(id).orElse(null);

	}

	public Books addBook(Books book) {
		return booksRepository.save(book);
	}

	public Books updateBook(Long id, Books updatedBook) {
		Books existingBook = booksRepository.findById(id).orElse(null);
		
		if (existingBook == null) {
			return null;
		}
		
		existingBook.setTitle(updatedBook.getTitle());
		existingBook.setAuthor(updatedBook.getAuthor());
		
		return booksRepository.save(existingBook);


	}

	public boolean deleteBook(Long id) {
		if (!booksRepository.existsById(id)) {
			return false;
		}
		booksRepository.deleteById(id);
		return true;
	}

}

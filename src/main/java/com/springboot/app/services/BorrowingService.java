package com.springboot.app.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.entities.Books;
import com.springboot.app.entities.BorrowingRecord;
import com.springboot.app.entities.Patron;
import com.springboot.app.repositories.BooksRepository;
import com.springboot.app.repositories.BorrowingRepository;
import com.springboot.app.repositories.PatronRepository;

@Service
public class BorrowingService {
	
	@Autowired
    private BorrowingRepository borrowingRepository;
	
	@Autowired
    private BooksRepository booksRepository;
    
    @Autowired
    private PatronRepository patronRepository;
	
	 public List<BorrowingRecord> getAllBorrowings() {
	        return borrowingRepository.findAll();
	    }
	 
	 public boolean borrowBook(Long bookId, Long patronId) {
		    Optional<BorrowingRecord> existingBorrowing = borrowingRepository.findByBook_IdAndPatron_Id(bookId, patronId);
		    if (existingBorrowing.isPresent()) {
		        return false; 
		    } else {
		        Optional<Books> bookOptional = booksRepository.findById(bookId);
		        Optional<Patron> patronOptional = patronRepository.findById(patronId);
		        
		        if (bookOptional.isPresent() && patronOptional.isPresent()) {
		            Books book = bookOptional.get();
		            Patron patron = patronOptional.get();
		            
		            BorrowingRecord newBorrowing = new BorrowingRecord();
		            newBorrowing.setBook(book);
		            newBorrowing.setPatron(patron);
		            
		            borrowingRepository.save(newBorrowing);
		            
		            return true; 
		        } else {
		            return false; 
		        }
		    }
		    
		}


	 public boolean returnBook(Long bookId, Long patronId) {
		    Optional<BorrowingRecord> borrowingOptional = borrowingRepository.findByBook_IdAndPatron_Id(bookId, patronId);

		    if (borrowingOptional.isPresent()) {
		        BorrowingRecord borrowingRecord = borrowingOptional.get();
		        borrowingRecord.setReturnDate(new java.sql.Date(new Date().getTime())); // Set return date

		        borrowingRepository.save(borrowingRecord);
		        return true; 
		    } else {
		        return false; 
		    }
		}


	 
}

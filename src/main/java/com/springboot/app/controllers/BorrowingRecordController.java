package com.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import com.springboot.app.services.BorrowingService;

@RestController
@RequestMapping("/api")
public class BorrowingRecordController {
	
	@Autowired
    private BorrowingService borrowingService;
	
	
    @PostMapping("/borrow/{bookId}/patron/{patronId}")
	public ResponseEntity<Void>borrow(@PathVariable Long bookId, @PathVariable Long patronId){
    	
    	boolean borrowed = borrowingService.borrowBook(bookId, patronId);
    	
    	if(!borrowed) {
    		return ResponseEntity.notFound().build();
    	}
    	
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
    
    @PostMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<Void>returnBook(@PathVariable Long bookId, @PathVariable Long patronId){
    	
    	boolean returned = borrowingService.returnBook(bookId, patronId);
    	
    	if(!returned) {
    		return ResponseEntity.notFound().build();
    	}
    	
		return ResponseEntity.status(HttpStatus.CREATED).build();
    	    	
    }
    
    
}

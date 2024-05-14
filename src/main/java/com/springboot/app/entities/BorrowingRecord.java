package com.springboot.app.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BorrowingRecord {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
    private Date borrowDate;
    private Date returnDate;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books book;
    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date date) {
		this.returnDate = date;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public Patron getPatron() {
		return patron;
	}
	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	public void setBook(Long bookId) {
		this.getBook().setId(bookId);
		
	}
	public void setPatron(Long patronId) {
		this.getPatron().setId(patronId);
		
	}
}

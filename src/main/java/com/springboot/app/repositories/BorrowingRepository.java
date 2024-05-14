package com.springboot.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.entities.BorrowingRecord;


@Repository
public interface BorrowingRepository extends JpaRepository <BorrowingRecord, Long> {

	Optional<BorrowingRecord> findByBook_IdAndPatron_Id(Long bookId, Long patronId);
	

	
}

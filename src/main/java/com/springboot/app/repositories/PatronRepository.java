package com.springboot.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.entities.Patron;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long>{

	List<Patron> findAll();


}

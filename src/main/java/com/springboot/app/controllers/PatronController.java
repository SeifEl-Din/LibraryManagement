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

import com.springboot.app.entities.Patron;
import com.springboot.app.services.PatronService;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

	@Autowired
    private PatronService patronService;
	
	@GetMapping
	public ResponseEntity<List<Patron>>getAllPatrons(){
		
		List<Patron> patrons = patronService.getAllPatrons();
		return ResponseEntity.ok().body(patrons);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
		
		Patron patron = patronService.getPatronById(id);
		return ResponseEntity.ok().body(patron);
		
	}
	
	@PostMapping("/addpatron")
	public ResponseEntity<Patron> addPatron(@RequestBody Patron patron){
		
		Patron addedPatron = patronService.addPatron(patron);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedPatron);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @RequestBody Patron updatedPatron){
		Patron patron = patronService.updatePatron(id, updatedPatron);
		
		if (patron == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(patron);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Patron> deletePatron(@PathVariable Long id){
		
		boolean deleted = patronService.deletePatron(id);
		
		if(!deleted) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();

}
}

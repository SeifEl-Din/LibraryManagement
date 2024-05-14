package com.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.entities.Patron;
import com.springboot.app.repositories.PatronRepository;

@Service
public class PatronService {

	@Autowired
    private PatronRepository patronRepository;
	
	public List<Patron> getAllPatrons() {
        return patronRepository.findAll();

	}

	public Patron getPatronById(Long id) {
		 return patronRepository.findById(id).orElse(null);
	}

	public Patron addPatron(Patron patron) {
        return patronRepository.save(patron);

	}

	public Patron updatePatron(Long id, Patron updatedPatron) {
		Patron existingPatron = patronRepository.findById(id).orElse(null);
        if (existingPatron == null) {
            return null; 
        }
        existingPatron.setName(updatedPatron.getName());
        existingPatron.setContactInformation(updatedPatron.getContactInformation());
        return patronRepository.save(existingPatron);
	}

	public boolean deletePatron(Long id) {
		 if (!patronRepository.existsById(id)) {
	            return false;
	        }
	        patronRepository.deleteById(id);
	        return true;
	}

}

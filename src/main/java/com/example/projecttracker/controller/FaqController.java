package com.example.projecttracker.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projecttracker.exception.ResourceNotFoundException;
import com.example.projecttracker.model.Faq;

import com.example.projecttracker.repository.FaqRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class FaqController {
	
	@Autowired
	private FaqRepository faqRepository;
	
	//get all FAQ
		@GetMapping("/faq")
		public List<Faq> getAllProject(){
			
			return faqRepository.findAll();
		}
		
		//create FAQ
		@PostMapping("/faq")
		public Faq createFaq(@RequestBody Faq faq) {
			return faqRepository.save(faq);
		}
		
		//get FAQ by id
		@GetMapping("/faq/{id}")
		public ResponseEntity<Faq> getFaqById(@PathVariable Long id) {
			
			Faq  faq = faqRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Faq not exist with id:"+id));
			return ResponseEntity.ok(faq);
			
		}
		
		//Update FAQ
		@PutMapping("/faq/{id}")
		public ResponseEntity<Faq> updateProject(@PathVariable Long id, @RequestBody Faq faqDetails){
			Faq faq = faqRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Faq not exist with id :" + id));
			
			faq.setFaqQuestion(faqDetails.getFaqQuestion());
			faq.setFaqAnswer(faqDetails.getFaqAnswer());
			
			
			Faq updatedFaq = faqRepository.save(faq);
			return ResponseEntity.ok(updatedFaq);
		}
	
		// delete FAQ
		@DeleteMapping("/faq/{id}")
		public ResponseEntity <Map<String, Boolean>> deleteFaq(@PathVariable Long id){
			Faq faq = faqRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Faq not exist with id :" + id));
			faqRepository.delete(faq);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
					
		}
	

}

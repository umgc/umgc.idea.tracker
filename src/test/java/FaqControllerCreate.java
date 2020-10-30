
package com.example.projecttracker;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.projecttracker.model.Faq;
import com.example.projecttracker.model.Project;
import com.example.projecttracker.model.User;
import com.example.projecttracker.repository.FaqRepository;
import com.example.projecttracker.repository.ProjectRepository;
import com.example.projecttracker.repository.UserRepository;

@RestController
public class FaqControllerCreate  {
	
	@Autowired
	private FaqRepository  repo;
	
	@RequestMapping(value="/faq", method=RequestMethod.GET)
	public Faq firstPage() {
		
		Faq faq = new Faq();
		faq.id = 1;
		faq.faqQuestion = "Good";
		faq.faqAnswer = "Yes";
		
		
		
	
		repo.save(faq);
		
		return faq;
		
		
		
	}
	

}
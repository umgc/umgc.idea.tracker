package edu.umgc.CaPPMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.umgc.CaPPMS.model.FAQ;
import edu.umgc.CaPPMS.repository.FAQRepository;

@RestController
@RequestMapping("/cappms") 
public class LoginController 
{
	@Autowired
	private FAQRepository faqRepository;
	
	@RequestMapping("/")
	public String home()
	{
		return "faq";
	}
	
	@GetMapping("/FAQ")
	public List<FAQ> getFAQ()
	{
		return this.faqRepository.findAll();
	}
}

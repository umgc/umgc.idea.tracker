package com.example.projecttracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class Faq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="faqQuestion")
	private String faqQuestion;
	
	@Column(name ="faqAnswer")
	private String faqAnswer;
	
	
	public Faq() {
		
	}
	
	public Faq(String faqQuestion, String faqAnswer) {
		super();
		this.faqQuestion = faqQuestion;
		this.faqAnswer = faqAnswer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFaqQuestion() {
		return faqQuestion;
	}
	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}
	public String getFaqAnswer() {
		return faqAnswer;
	}
	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}
	

}

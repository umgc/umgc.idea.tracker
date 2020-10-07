package edu.umgc.CaPPMS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FAQ" )
public class FAQ 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "FAQ_Question")
	private String faqQuestion;
	
	@Column(name = "FAQ_Answer")
	private String faqAnswer;
	
	public FAQ()
	{
		super();
	}
	
	public FAQ(long id, String faqQuestion, String faqAnswer) {
		super();
		this.id = id;
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

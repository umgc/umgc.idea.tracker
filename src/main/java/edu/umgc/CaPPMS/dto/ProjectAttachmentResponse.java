package edu.umgc.CaPPMS.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ProjectAttachmentResponse {

	
	private String project_descrition;
	private String file_name;
	private String file_path;
	
	public ProjectAttachmentResponse(String project_descrition, String file_name, String file_path) {
		super();
		this.project_descrition = project_descrition;
		this.file_name = file_name;
		this.file_path = file_path;
	}
	
	public ProjectAttachmentResponse() {
		
	}

	public String getProject_descrition() {
		return project_descrition;
	}

	public void setProject_descrition(String project_descrition) {
		this.project_descrition = project_descrition;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
    
	
   
	
	
	
	
}

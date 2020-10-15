package edu.umgc.CaPPMS.controller;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;




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

import edu.umgc.CaPPMS.exception.ResourceNotFoundException;
import edu.umgc.CaPPMS.model.Attachment;
import edu.umgc.CaPPMS.model.Project;
import edu.umgc.CaPPMS.repository.AttachmentRepository;
import edu.umgc.CaPPMS.repository.ProjectRepository;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class FileUploadController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@Autowired
    private AttachmentRepository attachmentRepository;
	
	
	
	
	@RequestMapping(value = "/upload",
	method = RequestMethod.POST,
	consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException
	{
		
		File convertFile = new File("/Users/marcbueno/eclipse-workspace-capstone/file-" + file.getOriginalFilename());
		convertFile.createNewFile();

		try (FileOutputStream fout = new FileOutputStream(convertFile))
		{
			fout.write(file.getBytes());
		}
		catch (Exception exe)
		{
			exe.printStackTrace();
		}
		return "File has been uploaded successfully";
	}
	
		//get all attachment
		@GetMapping("/attachment")
		public List<Attachment> getAllAttachment(){
			
			return attachmentRepository.findAll();
		}
		//create Attachment
		@PostMapping("/attachment")
		public Attachment createProject(@RequestBody Attachment attachment) {
			return attachmentRepository.save(attachment);
		}
		//get attachment by id
		@GetMapping("/attachment/{id}")
		public ResponseEntity<Attachment> getAttachmentById(@PathVariable Long id) {
			
			Attachment  attachment = attachmentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Attachment not exist with id:"+id));
			return ResponseEntity.ok(attachment);
			
		}
		//Update attachment
		@PutMapping("/attachment/{id}")
		public ResponseEntity<Attachment> updateAttachment(@PathVariable Long id, @RequestBody Attachment attachmentDetails){
			Attachment attachment = attachmentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Attachment not exist with id :" + id));
			
			attachment.setFile_name(attachmentDetails.getFile_name());
			attachment.setFile_descr(attachmentDetails.getFile_descr());
			attachment.setFile_path(attachmentDetails.getFile_path());
			
			
			Attachment updatedAttachment = attachmentRepository.save(attachment);
			return ResponseEntity.ok(updatedAttachment);
		}
		
		// delete attachment
		@DeleteMapping("/attachment/{id}")
		public ResponseEntity <Map<String, Boolean>> deleteAttachment(@PathVariable Long id){
			Attachment attachment = attachmentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Attachment not exist with id :" + id));
			attachmentRepository.delete(attachment);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
					
		}
	
	
}

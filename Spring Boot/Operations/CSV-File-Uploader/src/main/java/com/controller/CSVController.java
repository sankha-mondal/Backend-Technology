package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Tutorial;
import com.helper.CSVHelper;
import com.message.ResponseMessage;
import com.service.CSVService;


@CrossOrigin
@Controller
@RequestMapping("/csv")
public class CSVController {

  @Autowired
  CSVService fileService;
 
//========================================================================================================
  		
  		 //  Upload Operation:-
  
  		 //  http://localhost:9090/csv/upload

		  @PostMapping("/upload")
		  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		    String message = "";
		
		    if (CSVHelper.hasCSVFormat(file)) {
		      try {
		        fileService.save(file);
		
		        message = "Uploaded the file successfully: " + file.getOriginalFilename();
		        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		      } catch (Exception e) {
		        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		      }
		    }
		
		    message = "Please upload a csv file!";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
		  }
	  
	  
	  
  
//===================================================================================================================
		  
		  //  Retrieve all tutorials:-
		  
		  //  http://localhost:9090/csv/tutorials

		  @GetMapping("/tutorials")
		  public ResponseEntity<List<Tutorial>> getAllTutorials() {
		    try {
		      List<Tutorial> tutorials = fileService.getAllTutorials();
		
		      if (tutorials.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		
		      return new ResponseEntity<>(tutorials, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
  
  
	  
//==================================================================================================================
		  
		  //  Download CSV:-
		  
		  //  http://localhost:9090/csv/download

		  @GetMapping("/download")
		  public ResponseEntity<Resource> getFile() {
		    String filename = "tutorials.csv";
		    InputStreamResource file = new InputStreamResource(fileService.load());
		
		    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/csv"))
		        .body(file);
		  }
		  
		  
//=================================================================================================================

}

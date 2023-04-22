package com.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.Tutorial;
import com.entity.TutorialDetails;
import com.exception.ResourceNotFoundException;
import com.payload.ApiResponse;
import com.repository.TutorialDetailsRepository;
import com.repository.TutorialRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/details")
public class TutorialDetailsController {
	
	  @Autowired
	  private TutorialDetailsRepository detailsRepository;
	
	  @Autowired
	  private TutorialRepository tutorialRepository;
  
//======================================================================================================================================
//======================================================================================================================================
	  
	  //  Retrieve Operation:-  Op:1
	  
	  //  http://localhost:9090/details/getAll
	  
	  @GetMapping("/getAll")
	  public ResponseEntity<List<TutorialDetails>> getAllTutorialDetails() {
	    List<TutorialDetails> tutorial_detail = new ArrayList<TutorialDetails>();
	
	    detailsRepository.findAll().forEach(tutorial_detail::add);
	
		    if (tutorial_detail.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
	    return new ResponseEntity<>(tutorial_detail, HttpStatus.OK);
	  }
	  
	  
	  
//======================================================================================================================================

	  //  Retrieve Operation:-  Op:2
	  
	  //  http://localhost:9090/details/tutorials/{id}
	  
	  @GetMapping({ "/tutorials/{id}", "/tutorials/{id}/details" })
	  public ResponseEntity<TutorialDetails> getDetailsById(@PathVariable(value = "id") Long id) {
		  
		    TutorialDetails details = detailsRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial Details with id = " + id));
	
	    return new ResponseEntity<>(details, HttpStatus.OK);
	  }
	  
	  
	  
//======================================================================================================================================

	  //  Insert Operation:-    Op:3
	  
	  //  http://localhost:9090/details/tutorials/{tutorialId}/store
	  
	  @PostMapping("/tutorials/{tutorialId}/store")
	  public ResponseEntity<TutorialDetails> createDetails(@PathVariable(value = "tutorialId") Long tutorialId,
			  												@RequestBody TutorialDetails detailsRequest) {
	    Tutorial tutorial = tutorialRepository.findById(tutorialId)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
	
			    detailsRequest.setCreatedOn(new java.util.Date());
			    detailsRequest.setTutorial(tutorial);
			    TutorialDetails details = detailsRepository.save(detailsRequest);
	
	    return new ResponseEntity<>(details, HttpStatus.CREATED);
	  }
  
  
//======================================================================================================================================

	  //  Update Operation:-   Op:4
	  
	  //  http://localhost:9090/details/update/{id}
	  
	  @PutMapping("/update/{id}")
	  public ResponseEntity<TutorialDetails> updateDetails(@PathVariable("id") long id,
			  											   @RequestBody TutorialDetails detailsRequest) {
	    TutorialDetails details = detailsRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));
	
	    details.setCreatedBy(detailsRequest.getCreatedBy());
	
	    return new ResponseEntity<>(detailsRepository.save(details), HttpStatus.OK);
	  }
	  
  
  
//======================================================================================================================================
	  
	  //  Delete Operation by Id:-   Op:5
	  
	  //  http://localhost:9090/details/delete/{id}
	  
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<ApiResponse> deleteDetails(@PathVariable("id") long id) {
		  TutorialDetails tutorial_details = detailsRepository.findById(id)
			        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial Details with id = " + id));
	    
		  	detailsRepository.deleteById(id);
	
	    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		   return new ResponseEntity<ApiResponse>(new ApiResponse("Tutorial-Details deleted Successfully", true), HttpStatus.OK);
	  }
  
  
	  
  
//======================================================================================================================================

	  //  Delete Operation by Id:-   Op:5
	  
	  //  http://localhost:9090/details/delete/{tutorialId}
	  
	  @DeleteMapping("/delete/{tutorialId}")
	  public ResponseEntity<TutorialDetails> deleteDetailsOfTutorial(@PathVariable(value = "tutorialId") Long tutorialId) {
		  
		    if (!tutorialRepository.existsById(tutorialId)) {
		      throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
		    }
	
	    detailsRepository.deleteByTutorialId(tutorialId);
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
  
  
//======================================================================================================================================
//======================================================================================================================================
}
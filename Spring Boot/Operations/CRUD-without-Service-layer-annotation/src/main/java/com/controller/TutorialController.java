package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.Tutorial;
import com.exception.ResourceNotFoundException;
import com.payload.ApiResponse;
import com.repository.TutorialRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tutorials")		//  http://localhost:9090/tutorials
public class TutorialController {

  @Autowired
  TutorialRepository tutorialRepository;
  
//*************************************************** : CRUD Operation : *****************************************************************
  
//=======================================================================================================================================

  	 //  Retrieve Operation:-  Op:1
  
  	 //	 http://localhost:9090/tutorials/getAll
  
	  @GetMapping("/getAll")
	  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
	    List<Tutorial> tutorials = new ArrayList<Tutorial>();
	
		    if (title == null)
		      tutorialRepository.findAll().forEach(tutorials::add);
		    else
		      tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
		
		    if (tutorials.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		
		    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  }
	  
  
  
//=======================================================================================================================================
  
	  //  Retrieve data by Id :-  Op:2
	  
	  //  http://localhost:9090/tutorials/getById/{id}

	  @GetMapping("/getById/{id}")
	  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
	    Tutorial tutorial = tutorialRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
	
	    	return new ResponseEntity<>(tutorial, HttpStatus.OK);
	  }
	  
  
  
//=======================================================================================================================================

	  //  Insert Operation:-    Op:3
	  
	  //  http://localhost:9090/tutorials/store
	  
	  @PostMapping("/store")
	  public ResponseEntity<Tutorial> createTutorial(@Valid @RequestBody Tutorial tutorial) {
	    Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished()));
	    return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
	  }
	  
	  /**
	     {
		  "title" : "Java",
		  "description" : "This is complete tutorial of java",
		  "published" : true
		 }
	  */
	  
   
//=======================================================================================================================================

	  //  Update Operation:-   Op:4
	  
	  //  http://localhost:9090/tutorials/update/{id}
	  
	  @PutMapping("/update/{id}")
	  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id,@Valid @RequestBody Tutorial tutorial) {
	    Tutorial _tutorial = tutorialRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
	
		    _tutorial.setTitle(tutorial.getTitle());
		    _tutorial.setDescription(tutorial.getDescription());
		    _tutorial.setPublished(tutorial.isPublished());
	    
	    return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
	  }
	  
	  
  
//=======================================================================================================================================

	  //  Delete Operation by Id:-   Op:5
	  
	  //  http://localhost:9090/tutorials/delete/{id}
	  
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<ApiResponse> deleteTutorial(@PathVariable("id") long id) {
		  Tutorial tutorial_id = tutorialRepository.findById(id)
			        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
		  
		  tutorialRepository.deleteById(id);
	    
	    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  return new ResponseEntity<ApiResponse>(new ApiResponse("Tutorial deleted Successfully", true), HttpStatus.OK);
	  }
	  
	  
  
//=======================================================================================================================================
  
	  //  All Delete Operation:-   Op:6
	 
	  //  http://localhost:9090/tutorials/deleteAll

	  @DeleteMapping("/deleteAll")
	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
		  tutorialRepository.deleteAll();
	    
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
  
//=======================================================================================================================================

//**************************************************** : User Define : *****************************************************************
	  
//======================================================================================================================================
	  
	  //  Retrieve data by published Operation:-   Op:7
	  
	  //  http://localhost:9090/tutorials/getAllBy/published
	  
	  @GetMapping("/getAllBy/published")
	  public ResponseEntity<List<Tutorial>> findByPublished() {
	    List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
	
	    if (tutorials.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  }
	  
  
  
//=======================================================================================================================================
	  
	  //  Retrieve data by title Operation:-   Op:8
	  
	  //  http://localhost:9090/tutorials/getAllBy/{title}
	  
	  @GetMapping("/getAllBy/{title}")
	  public ResponseEntity<List<Tutorial>> findByTitleContaining(@PathVariable("title") String title) {
	    List<Tutorial> tutorials = tutorialRepository.findByTitleContaining(title);

		    if (tutorials.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
	    
	    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  }
	  
	  
	
//=======================================================================================================================================
	  
	  //  Retrieve data by Title Operation:-   Op: 9
	  
	  //  http://localhost:9090/tutorials/findTutorialByTitle/{title}
	  
	  @GetMapping("/findTutorialByTitle/{title}")
	  public ResponseEntity<List<Tutorial>> findTutorialByTitle(@PathVariable("title") String title) {
	    List<Tutorial> tutorials = tutorialRepository.findTutorialByTitle(title);

		    if (tutorials.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
	    
	    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  }
	  
	  
	  
//=======================================================================================================================================

	  //  Retrieve data by Title Operation:-   Op: 10
	  
	  //  http://localhost:9090/tutorials/findTutorialByTitle/{title}/{published}
	  
	  @GetMapping("/findTutorialByTitle/{title}/{published}")
	  public ResponseEntity<List<Tutorial>> findTutorialByTitlepublish(@PathVariable("title") String title, 
			  														   @PathVariable("published") boolean published) {
	    List<Tutorial> tutorials = tutorialRepository.findTutorialByTitlepublish(title, published);

		    if (tutorials.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
	    
	    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  }
	  
	  
	  
//=======================================================================================================================================
	  
	  //  Retrieve data Order by Id Operation:-   Op:11
	  
	  //  http://localhost:9090/tutorials/sortTutorialById
	  
	  @GetMapping("/sortTutorialById")
	  public ResponseEntity<List<Tutorial>> sortTutorialById() {
	    List<Tutorial> tutorials = tutorialRepository.sortTutorialById();

		    if (tutorials.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
	    
	    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	  }
	  
	  
	  
//=======================================================================================================================================
	  
	  //  Search Operation by like Title      Op:12
	  
	  //  http://localhost:9090/tutorials/search/{keyword}
	  
	  @GetMapping("/search/{keyword}")
	  public ResponseEntity<List<Tutorial>> searchByTitle(@PathVariable("keyword") String keyword) {
	    List<Tutorial> tutorials = tutorialRepository.searchByTitle("%"+keyword+"%");

		    if (tutorials.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
	    
	    return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    
	  }
	  
	  
	  
//=======================================================================================================================================
	  
	  
	  //  Delete data  Operation:-   Op: 13
	  
	  //  http://localhost:9090/tutorials/deleteTutorialByTitle/{title}
	  
//	  @GetMapping("/deleteTutorialByTitle/{title}")    // Not Working
//	  public ResponseEntity<ApiResponse> deleteTutorialByTitle(@PathVariable("title") String title) {
//	    int tutorials = tutorialRepository.deleteTutorialByTitle(title);
//
//		    if (tutorials<1) {
//		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		    }
//	    
//	    // return new ResponseEntity<>(HttpStatus.OK);
//		   return new ResponseEntity<ApiResponse>(new ApiResponse("Tutorial deleted Successfully", true), HttpStatus.OK);
//	  }
	  
	  
//=======================================================================================================================================
	  
}

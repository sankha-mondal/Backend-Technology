package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Tutorial;
import com.exception.ResourceNotFoundException;
import com.repository.TutorialRepository;

@Service
public class TutorialService {
	
	@Autowired
	TutorialRepository tutorialRepo;
	
	
//=======================================================================================================================================
	  
//*************************************************** : CRUD Operation : ****************************************************************
	  
//=======================================================================================================================================
	
			//  Retrieve Operation:-  Op:1
			
			public List<Tutorial> getAllTutorials() {
				List<Tutorial> tutorials = tutorialRepo.findAll();
		
				return tutorials;
			}
	
	
	
//=======================================================================================================================================
	
			//  Retrieve data by Id :-  Op:2
			
			public Tutorial getTuteById(Long id) {
				Tutorial tutorial = tutorialRepo.findById(id)
				        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
				
				return tutorial;
			}
	
			
	
//=======================================================================================================================================
	
			//  Insert Operation:-    Op:3
			
			public Tutorial createTutorial(Tutorial tutorial) {
				boolean res = tutorialRepo.existsById(tutorial.getId());
				
				if(res) {
					System.out.println("Tutorial details didn't Stored...");
					return null;
				} else {
					Tutorial _tutorial = tutorialRepo.save(tutorial);
					System.out.println("Tutorial details Stored successfully...");
					// Tutorial _tutorial = tutorialRepo.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished()));
					return _tutorial;	
				}
				
			}
		
		
	
//=======================================================================================================================================
		
			//  Update Operation:-   Op:4
			
			public Tutorial updateTutorial(Tutorial tutorial, Long tutorialId) {
				Tutorial _tutorial = tutorialRepo.findById(tutorialId)
				        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
				
					    _tutorial.setTitle(tutorial.getTitle());
					    _tutorial.setDescription(tutorial.getDescription());
					    _tutorial.setPublished(tutorial.isPublished());
					    System.out.println("Details Updated...");
					    
				return _tutorial;
				
			}
		
		

//=======================================================================================================================================
			
			//  Delete Operation by Id:-   Op:5
		
			public void deleteTutorial(Long tutorialId) {
				Tutorial tutorial_id = tutorialRepo.findById(tutorialId)
				        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
				
				System.out.println("Tutorial Deleted...");
				tutorialRepo.deleteById(tutorialId);
			}
			
			
			
//=======================================================================================================================================
			
			//  Delete All Operation:-   Op:6
			
			public void deleteAllTutorial() {
				
				tutorialRepo.deleteAll();
				
			}
			
			
			
			
//=======================================================================================================================================

//**************************************************** : User Define : *****************************************************************
				  
//======================================================================================================================================
	
			//  Retrieve data by published Operation:-   Op:7
			
			public List<Tutorial> findByPublished() {
				List<Tutorial> tutorials = tutorialRepo.findByPublished(true);
				
				return tutorials;
			}

						
//======================================================================================================================================
			
			//  Retrieve data by title Operation:-   Op:8
			
			public List<Tutorial> findByTitleContaining(String title) {
				List<Tutorial> tutorials = tutorialRepo.findByTitleContaining(title);
				
				return tutorials;
			}
			
			
//======================================================================================================================================
			
			//  Retrieve data by Title Operation:-   Op: 9	
			
			public List<Tutorial> findTutorialByTitle(String title) {
				List<Tutorial> tutorials = tutorialRepo.findTutorialByTitle(title);
				
				return tutorials;
			}
			

//======================================================================================================================================
			
			//  Retrieve data by Title Operation:-   Op: 10
			
			public List<Tutorial> findTutorialByTitlepublish(String title, boolean published) {
				List<Tutorial> tutorials = tutorialRepo.findTutorialByTitlepublish(title, published);
				
				return tutorials;
			}
			
			
//=======================================================================================================================================
			
			//  Retrieve data Order by Id Operation:-   Op:11
			
			public List<Tutorial> sortTutorialById() {
				List<Tutorial> tutorials = tutorialRepo.sortTutorialById();
				
				return tutorials;
			}
			
//=======================================================================================================================================
			
			//  Search Operation by like Title:-      Op:12
			
			public List<Tutorial> searchByTitle(String keyword) {
				List<Tutorial> tutorials = tutorialRepo.searchByTitle(keyword);
				
				return tutorials;
			}
			
			
//=======================================================================================================================================
			
			//  Delete data  Operation:-   Op: 13
			
//			public String deleteTutorialByTitle(String title) {
//				int delete_done = tutorialRepo.deleteTutorialByTitle(title);
//				
//				if(delete_done>0) {
//					return "User details deleted successfully...";
//				} else {
//					return "User not present...";
//				}
//			}
			
			
//=======================================================================================================================================
			
			
			
			
			
			
			
}

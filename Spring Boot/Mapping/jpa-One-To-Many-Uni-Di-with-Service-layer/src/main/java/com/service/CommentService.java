package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.entity.Comment;
import com.entity.Tutorial;
import com.exception.ResourceNotFoundException;
import com.payload.ApiResponse;
import com.repository.CommentRepository;
import com.repository.TutorialRepository;

@Service
public class CommentService {
	
	  @Autowired
	  private TutorialRepository tutorialRepo;

	  @Autowired
	  private CommentRepository commentRepo;
	 
	  
//=================================================================================================================================================================
//=========================================================================== : CRUD : ============================================================================
//=================================================================================================================================================================
	  
		   //  Retrieve Operation:-  Op:1
			
			public List<Comment> getAllComment() {
				List<Comment> comments = commentRepo.findAll();
		
				return comments;
			}
			
			
			
//================================================================================================================================================================
	  
		  //  Retrieve Comments by tutorial-Id:-  Op:2
			  
		  public List<Comment> getCommentsByTutorialId(Long tutorialId) {  
			  
		    Tutorial tutorial = tutorialRepo.findById(tutorialId)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
		
			    List<Comment> comments = new ArrayList<Comment>();
			    comments.addAll(tutorial.getComments());
		    
		    return comments;
		  }
		  
		  
//=================================================================================================================================================================
	  
		  //  Retrieve single_comment by comment-Id:-  Op:3
	
		  public Comment getCommentByTutorialId(@PathVariable(value = "commentId") Long commentId) {
			  
		    Comment single_comment = commentRepo.findById(commentId)
		        .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + commentId));
		
		    return single_comment;
		  }
	  
  
//=================================================================================================================================================================
		  
		  //  Insert Operation with tutorial-Id:-    Op:4
		  
		  public Comment createComment(Long tutorialId, Comment commentRequest) {
			  
		    Comment comment = tutorialRepo.findById(tutorialId).map(tutorial -> {
		    			tutorial.getComments().add(commentRequest);
		    			
		      return commentRepo.save(commentRequest);
		    }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
		
		    return comment;
		  }
		  
		  
//=================================================================================================================================================================

		  //  Update Operation by Comment-id:-   Op:5
		  
		  public Comment updateComment(long id, Comment commentRequest) {
			  
		    Comment _comment = commentRepo.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + " not found"));
		
			    _comment.setContent(commentRequest.getContent());
			    
			    Comment update_comment = commentRepo.save(_comment);
				System.out.println("Comment updated successfully...");
		
		    return update_comment;
		  }
		  
		  
//=================================================================================================================================================================

		  //  Delete Operation by Id:-   Op:6
		  
		  public void deleteComment(@PathVariable("id") long id) {
			  
				  Comment comment_id = commentRepo.findById(id)
					        .orElseThrow(() -> new ResourceNotFoundException("Comment Id "+id+" not found"));
				  
				  System.out.println("Comment Deleted...");
				  commentRepo.deleteById(id);	
		  }
		  
//=================================================================================================================================================================
//=================================================================================================================================================================

		  
		  
		  
		  
		  
		  
		  
		  
		  

}

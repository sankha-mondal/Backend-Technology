package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.Comment;
import com.entity.Tutorial;
import com.exception.ResourceNotFoundException;
import com.payload.ApiResponse;
import com.repository.CommentRepository;
import com.repository.TutorialRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comments")       //  http://localhost:9090/comments
public class CommentController {

  @Autowired
  private TutorialRepository tutorialRepository;

  @Autowired
  private CommentRepository commentRepository;
  
//======================================================================================================================================
 
  	  //  Retrieve by tutorial-Id:-  Op:1
  
  	  //  http://localhost:9090/comments/getByTutorial/{tutorialId}
  
	  @GetMapping("/getByTutorial/{tutorialId}")
	  public ResponseEntity<List<Comment>> getAllCommentsByTutorialId(@PathVariable(value = "tutorialId") Long tutorialId) {    
	    Tutorial tutorial = tutorialRepository.findById(tutorialId)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
	
		    List<Comment> comments = new ArrayList<Comment>();
		    comments.addAll(tutorial.getComments());
	    
	    return new ResponseEntity<>(comments, HttpStatus.OK);
	  }
  
  
//======================================================================================================================================

	  //  Retrieve by comment-Id:-  Op:2
	  
	  //  http://localhost:9090/comments/comment/{commentId}

	  @GetMapping("/comment/{commentId}")
	  public ResponseEntity<Comment> getCommentsByTutorialId(@PathVariable(value = "commentId") Long commentId) {
	    Comment comment = commentRepository.findById(commentId)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + commentId));
	
	    return new ResponseEntity<>(comment, HttpStatus.OK);
	  }
  
  
//======================================================================================================================================

	  //  Insert Operation with tutorial-Id:-    Op:3
	  
	  //  http://localhost:9090/comments/store/{tutorialId}
	  
	  @PostMapping("/store/{tutorialId}")
	  public ResponseEntity<Comment> createComment( @PathVariable(value = "tutorialId") Long tutorialId,
			  										@RequestBody Comment commentRequest) {
	    Comment comment = tutorialRepository.findById(tutorialId).map(tutorial -> {
	      tutorial.getComments().add(commentRequest);
	      return commentRepository.save(commentRequest);
	    }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
	
	    return new ResponseEntity<>(comment, HttpStatus.CREATED);
	  }
  
  
//======================================================================================================================================

	  //  Update Operation by Comment-id:-   Op:4
	  
	  //  http://localhost:9090/comments/update/{id}
	  
	  @PutMapping("/update/{id}")
	  public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment commentRequest) {
	    Comment comment = commentRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + " not found"));
	
	    comment.setContent(commentRequest.getContent());
	
	    return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
	  }
  
  
//======================================================================================================================================

	  //  Delete Operation by Id:-   Op:5
	  
	  //  http://localhost:9090/comments/delete/{id}
	  
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<ApiResponse> deleteComment(@PathVariable("id") long id) {
		  Comment comment_id = commentRepository.findById(id)
			        .orElseThrow(() -> new ResourceNotFoundException("Comment Id " + id + " not found"));
		  
		  commentRepository.deleteById(id);
	
	    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  return new ResponseEntity<ApiResponse>(new ApiResponse("Comment content deleted Successfully", true), HttpStatus.OK);
	  }
  
//======================================================================================================================================

	  //  http://localhost:9090/comments/tutorials/{tutorialId}/comments
	  /**   Not Working
	  @DeleteMapping("/tutorials/{tutorialId}/comments")
	  public ResponseEntity<List<Comment>> deleteAllCommentsOfTutorial(@PathVariable(value = "tutorialId") Long tutorialId) {
	    if (!tutorialRepository.existsById(tutorialId)) {
	      throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
	    }
	    commentRepository.deleteByTutorialId(tutorialId);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  */
  
  
//======================================================================================================================================

  
  
}


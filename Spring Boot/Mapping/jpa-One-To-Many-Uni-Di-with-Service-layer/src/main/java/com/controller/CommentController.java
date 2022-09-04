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
import com.service.CommentService;
import com.service.TutorialService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comments")       //  http://localhost:9090/comments
public class CommentController {

	  @Autowired
	  private TutorialRepository tutorialRepository;
	  
	  @Autowired
	  private TutorialService tutorialService;
	
	  @Autowired
	  private CommentRepository commentRepository;
	  
	  @Autowired
	  private CommentService commentService;
 
  
//======================================================================================================================================
//====================================================== : CRUD : ======================================================================
//======================================================================================================================================

		  //  Retrieve All Comments:-  Op:1
		
		  //  http://localhost:9090/comments/getAll
		
		  @GetMapping("/getAll")
		  public ResponseEntity<List<Comment>> getAllComment() {
			  
		    List<Comment> comments = commentService.getAllComment();
			
			    if (comments.isEmpty()) {
			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			    }
			 return new ResponseEntity<>(comments, HttpStatus.OK);
		  }
  
	  
	  
//======================================================================================================================================
 
	  	  //  Retrieve Comments by tutorial-Id:-  Op:2
	  
	  	  //  http://localhost:9090/comments/getByTutorial/{tutorialId}
	  
		  @GetMapping("/getByTutorial/{tutorialId}")
		  public ResponseEntity<List<Comment>> getCommentsByTutorialId(@PathVariable(value = "tutorialId") Long tutorialId) {    
			  
			  	List<Comment> comments = commentService.getCommentsByTutorialId(tutorialId);
			     
		    return new ResponseEntity<>(comments, HttpStatus.OK);
		  }
  
  
//======================================================================================================================================

		  //  Retrieve single_comment by comment-Id:-  Op:3
		  
		  //  http://localhost:9090/comments/comment/{commentId}
	
		  @GetMapping("/comment/{commentId}")
		  public ResponseEntity<Comment> getCommentByTutorialId(@PathVariable(value = "commentId") Long commentId) {
			  
			  	Comment single_comment = commentService.getCommentByTutorialId(commentId);
		
		    return new ResponseEntity<>(single_comment, HttpStatus.OK);
		  }
	  
  
//======================================================================================================================================

		  //  Insert Operation with tutorial-Id:-    Op:4
		  
		  //  http://localhost:9090/comments/store/{tutorialId}
		  
		  @PostMapping("/store/{tutorialId}")
		  public ResponseEntity<Comment> createComment( @PathVariable(value = "tutorialId") Long tutorialId,
				  										@RequestBody Comment commentRequest) {
			  
			  	Comment _comment = commentService.createComment(tutorialId, commentRequest);
		
		    return new ResponseEntity<>(_comment, HttpStatus.CREATED);
		  }
  
  
//======================================================================================================================================

		  //  Update Operation by Comment-id:-   Op:5
		  
		  //  http://localhost:9090/comments/update/{id}
		  
		  @PutMapping("/update/{id}")
		  public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment commentRequest) {
			  
			  	Comment _comment = commentService.updateComment(id, commentRequest);
			    
			return new ResponseEntity<>( _comment, HttpStatus.OK);
		  }
  
  
//======================================================================================================================================

		  //  Delete Operation by Id:-   Op:6
		  
		  //  http://localhost:9090/comments/delete/{id}
		  
		  @DeleteMapping("/delete/{id}")
		  public ResponseEntity<ApiResponse> deleteComment(@PathVariable("id") long id) {
			  
			  commentService.deleteComment(id);
		
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
//======================================================================================================================================
  
  
}


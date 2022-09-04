package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	
	  @Lob
	  @Column(name = "comment_content")
	  private String content;
	  
	  /**
		   	{
	  		"content" : "Thank you sir for this tutorial "
			}   
	   */
	  
//=====================================================================================================================================
	  
	
	  public Long getId() {
	    return id;
	  }
	
	  public String getContent() {
	    return content;
	  }
	
	  public void setContent(String content) {
	    this.content = content;
	  }

	  @Override
	  public String toString() {
	    return "Comment [id=" + id + ", content=" + content + "]";
	  }
	  
}


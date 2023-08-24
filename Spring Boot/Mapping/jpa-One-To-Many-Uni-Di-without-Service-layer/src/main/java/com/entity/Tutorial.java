package com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tutorials")
public class Tutorial {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	
	  @Column(name = "title")
	  private String title;
	
	  @Column(name = "description")
	  private String description;
	
	  @Column(name = "published")
	  private boolean published;
	  
	  	  /**
		     {
			  "title" : "Java",
			  "description" : "This is complete tutorial of java",
			  "published" : true
			 }
	  	  */
	
	  @OneToMany(targetEntity=Comment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	  @JoinColumn(name = "tutorial_id", referencedColumnName="id")
	  private Set<Comment> comments = new HashSet<>();    // One Tutorial has many Comments.
	  
//===================================================================================================================================

	  
	  public Tutorial() {
	
	  }
	
	  //  Impotent for insert operation
	  public Tutorial(String title, String description, boolean published) {
	    this.title = title;
	    this.description = description;
	    this.published = published;
	  }
	  
	  
	  @Override
	  public String toString() {
	    return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	  }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}

package com.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tutorials")
public class Tutorial {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	
	  @Column(name = "title")
	  @NotNull
	  @Size(min = 2, message = "Title must be min of 2 chatacters")
	  private String title;
	
	  @Column(name = "description")
	  @NotNull
	  @Size(min = 2, message = "Description should be there")
	  private String description;
	
	  @Column(name = "published")
	  @NotNull(message = "Enter true or false")
	  private boolean published;
	  
	  	  /**
		     {
			  "title" : "Java",
			  "description" : "This is complete tutorial of java",
			  "published" : true
			 }
	  	  */
	
	  
//===================================================================================================================================

	  
	  public Tutorial() {
	
	  }
	
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


}

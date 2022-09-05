package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial {

	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	
	  @Column(name = "title")
	  private String title;
	
	  @Column(name = "description")
	  private String description;
	
	  @Column(name = "published")
	  private boolean published;
	  
//====================================================================
	
	  public Tutorial() {
	
	  }
	
	  public Tutorial(long id, String title, String description, boolean published) {
	    this.id = id;
	    this.title = title;
	    this.description = description;
	    this.published = published;
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
	
	  public void setPublished(boolean isPublished) {
	    this.published = isPublished;
	  }
	
	  @Override
	  public String toString() {
	    return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
	  }

}

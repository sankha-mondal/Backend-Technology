package com.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tutorial_details")
public class TutorialDetails {
	
	  @Id
	  private Long id; 	// This id never be a PK. This will matched with tutorials-Id of Tutorials class.
	
	  @Column
	  private Date createdOn;
	
	  @Column
	  private String createdBy;
	
	  @OneToOne(fetch = FetchType.LAZY)
	  @MapsId
	  @JoinColumn(name = "tutorial_id")
	  private Tutorial tutorial;
	  /**
	  {
		  "createdBy" : "Rajesh kumar Dey"
	  }
	  */
//=========================================================================================  
	
	  public TutorialDetails() {
	  }
	
	  public TutorialDetails(String createdBy) {
	    this.createdOn = new Date();
	    this.createdBy = createdBy;
	  }
	
	  public Date getCreatedOn() {
	    return createdOn;
	  }
	
	  public void setCreatedOn(Date createdOn) {
	    this.createdOn = createdOn;
	  }
	
	  public String getCreatedBy() {
	    return createdBy;
	  }
	
	  public void setCreatedBy(String createdBy) {
	    this.createdBy = createdBy;
	  }
	
	  public Tutorial getTutorial() {
	    return tutorial;
	  }
	
	  public void setTutorial(Tutorial tutorial) {
	    this.tutorial = tutorial;
	  }

}
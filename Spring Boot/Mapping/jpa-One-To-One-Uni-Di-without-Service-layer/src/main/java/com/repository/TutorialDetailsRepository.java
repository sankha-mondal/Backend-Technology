package com.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.TutorialDetails;


@Repository
public interface TutorialDetailsRepository extends JpaRepository<TutorialDetails, Long> {
	
	  @Transactional
	  void deleteById(long id);
	  
	  @Transactional
	  void deleteByTutorialId(long tutorialId);
	  
}



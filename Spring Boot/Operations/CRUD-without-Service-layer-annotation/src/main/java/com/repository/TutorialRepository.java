package com.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Tutorial;


@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	
	List<Tutorial> findByPublished(boolean published);  		// Op:7
	
	List<Tutorial> findByTitleContaining(String title);			// Op:8
	  
	
	@Query("select t from Tutorial t where t.title = :title and t.published = :published")		// Op:9
	public List<Tutorial> findTutorialByTitlepublish(@Param("title") String title, @Param("published") boolean published);
	
	
	@Query("select t from Tutorial t where t.title = :title")			// Op:10
	public List<Tutorial> findTutorialByTitle(@Param("title") String title);
	  	
	
	@Query("select t from Tutorial t order by t.id desc")  		// Op:11
	public List<Tutorial> sortTutorialById();
	
	
	@Query("select t from Tutorial t where t.title like :key")   		// Op:12
	public List<Tutorial> searchByTitle(@Param("key") String title);
	
	
	@Modifying(clearAutomatically = true)					// Op:13
	@Transactional
	@Query("delete from Tutorial t where t.title = :title")
	public int deleteTutorialByTitle(@Param("title") String title);
	
	
}
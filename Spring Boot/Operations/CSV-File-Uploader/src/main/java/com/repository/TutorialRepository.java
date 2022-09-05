package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.Tutorial;



public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}

package com.proman.metropolia.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proman.metropolia.models.anIdea;

@Repository
public interface ideaRepo extends JpaRepository<anIdea, Long> {

	
}

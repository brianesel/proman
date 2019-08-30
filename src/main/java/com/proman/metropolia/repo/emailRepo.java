package com.proman.metropolia.repo;

import com.proman.metropolia.models.emailIdeaer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface emailRepo extends JpaRepository<emailIdeaer, Long> {

	emailIdeaer findByEmail(String email);

	Boolean existsByEmail(String email);
}

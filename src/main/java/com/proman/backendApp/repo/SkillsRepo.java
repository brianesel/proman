package com.proman.backendApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proman.backendApp.model.Skills;

@Repository
public interface SkillsRepo extends JpaRepository<Skills, Long> {

    Optional<Skills> findBySkillName(String name);

}

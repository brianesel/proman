package com.proman.backendApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proman.backendApp.model.SkillLevel;

@Repository
public interface SkillLevelRepo extends JpaRepository<SkillLevel, Long> {

    Optional<SkillLevel> findBySkillLevel(int skill_level);

}

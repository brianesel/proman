package com.proman.backendApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proman.backendApp.model.CVStorage;

@Repository
public interface CVStorageRepo extends JpaRepository<CVStorage, Long> {
}

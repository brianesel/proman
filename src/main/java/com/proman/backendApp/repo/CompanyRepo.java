package com.proman.backendApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proman.backendApp.model.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);

}

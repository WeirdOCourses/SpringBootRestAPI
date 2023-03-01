package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

	Optional<Candidate> findByCandidateName(String candidate_name);

  


}

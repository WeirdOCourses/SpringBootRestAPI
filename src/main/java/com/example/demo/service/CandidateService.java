package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Candidate;
import com.example.demo.repository.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
	CandidateRepository candidateRepository;
	
	public Candidate insertCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		
		if(candidateRepository.findByCandidateName(candidate.getcandidateName()).isPresent()) {
			return null;
		} else {

			return candidateRepository.save(candidate);
		}
		
		}
	

	public List<Candidate> insertAllCandidate(List<Candidate> candidate) {
		// TODO Auto-generated method stub
		
	

			return candidateRepository.saveAll(candidate);
		
		
		}

	public List<Candidate> retriveCandidates() {
		return candidateRepository.findAll();
	}
	
	public Optional<Candidate> retriveCandidate(String name) {
		return candidateRepository.findByCandidateName(name);
	}
	
	
	
	
	public Candidate updateCandidateByName(Candidate candidate, String name) {
		
		if(candidateRepository.findByCandidateName(name).isPresent()) {
			Candidate _candidate = new Candidate();
			_candidate.setId(candidateRepository.findByCandidateName(name).get().getId());
			_candidate.setcandidateName(candidate.getcandidateName());
			_candidate.setCandidate_score(candidate.getCandidate_score());
			_candidate.setIs_successful(candidate.isIs_successful());
			return candidateRepository.save(_candidate);
		}else 
			return null;
		
	}
	
public Candidate updateCandidateById(Candidate candidate, int id) {
		
		if(candidateRepository.findById(id).isPresent()) {
			Candidate _candidate = new Candidate();
			_candidate.setId(id);
			_candidate.setcandidateName(candidate.getcandidateName());
			_candidate.setCandidate_score(candidate.getCandidate_score());
			_candidate.setIs_successful(candidate.isIs_successful());
			return candidateRepository.save(_candidate);
		}else 
			return null;
		
	}
	
	public boolean deleteCandidate(int id) {
		if(candidateRepository.findById(id).isPresent()) {
		candidateRepository.deleteById(id); 
		return true;
		}
		else return false;
	}

	public Optional<Candidate> retriveCandidateById(int id) {
		// TODO Auto-generated method stub
		return candidateRepository.findById(id);
	}

}

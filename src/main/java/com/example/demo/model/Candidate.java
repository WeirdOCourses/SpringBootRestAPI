package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="interview_results")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="candidate_name")
	private String candidateName;
	private double candidate_score;
	private boolean is_successful;
	
	
	public String getcandidateName() {
		return candidateName;
	}
	public void setcandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public double getCandidate_score() {
		return candidate_score;
	}
	public void setCandidate_score(double candidate_score) {
		this.candidate_score = candidate_score;
	}
	public boolean isIs_successful() {
		return is_successful;
	}
	public void setIs_successful(boolean is_successful) {
		this.is_successful = is_successful;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

	public Candidate(int id, String candidateName, double candidate_score, boolean is_successful) {
		super();
		this.id = id;
		this.candidateName = candidateName;
		this.candidate_score = candidate_score;
		this.is_successful = is_successful;
	}
	
	
	
	public Candidate(String candidateName, double candidate_score, boolean is_successful) {
		super();
		this.candidateName = candidateName;
		this.candidate_score = candidate_score;
		this.is_successful = is_successful;
	}
	public Candidate(double candidate_score) {
		super();
		this.candidate_score = candidate_score;
	}
	public Candidate() {
		super();
	}
	
	
	

}

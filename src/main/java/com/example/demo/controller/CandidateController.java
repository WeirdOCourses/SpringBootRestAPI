package com.example.demo.controller;

import java.util.List;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.CandidateNotFoundException;
import com.example.demo.model.Candidate;
import com.example.demo.service.CandidateService;

@RestController
@RequestMapping("/api/v1")
public class CandidateController {
	
	@Autowired
	CandidateService candidateService;
	
	
	//This is to add candidates
	@PostMapping("/candidates")
	//@RequestMapping(name = "/candidates", method = RequestMethod.POST)
	public ResponseEntity<Object> insertCandidate(@RequestBody Candidate candidate)
	{
		try {
           if(candidate.getCandidate_score()>100) {
        		return new ResponseEntity<>("Score Above limit", HttpStatus.NOT_ACCEPTABLE);
			}
		else if(candidateService.insertCandidate(candidate) == null)
			{
				return new ResponseEntity<>("Candidates Already Exists", HttpStatus.NOT_ACCEPTABLE);	
			} else 
			return new ResponseEntity<>("Candidates added successfully", HttpStatus.CREATED);
		}catch (Exception e) {
		    return new ResponseEntity<>("Service unavailable, Try again", HttpStatus.SERVICE_UNAVAILABLE);  	
		}
		
	}
	
	@PostMapping("/allcandidates")
	//@RequestMapping(name = "/allcandidates", method = RequestMethod.POST)
	public ResponseEntity<Object> insertAllCandidate(@RequestBody List<Candidate> candidate)
	{
		try {
        ;
			
			return new ResponseEntity<>(   
					candidateService.insertAllCandidate(candidate), HttpStatus.CREATED);
		}catch (Exception e) {
		    return new ResponseEntity<>("Service unavailable, Try again", HttpStatus.SERVICE_UNAVAILABLE);  	
		}
		
	}
	
	//This is to get all  candidates
	@GetMapping("/candidates")
	//@RequestMapping(name = "/candidates", method = RequestMethod.GET)
	public ResponseEntity<Object> retriveCandidate()
	{
		try {
			
			return new ResponseEntity<>(candidateService.retriveCandidates(), HttpStatus.OK);
		}catch (Exception e) {
		    return new ResponseEntity<>("Service unavailable, Try again", HttpStatus.SERVICE_UNAVAILABLE);  	
		}
		
	}
	
	//This is to get candidates by their name
	@GetMapping("/candidate")
	//@RequestMapping(name = "/candidate", method = RequestMethod.GET)
	public ResponseEntity<Object> getCandidate(@RequestParam String candidate_name) {
	
		if(candidateService.retriveCandidate(candidate_name).isPresent()) {
		return new ResponseEntity<>(candidateService.retriveCandidate(candidate_name), HttpStatus.OK);}
		else throw new CandidateNotFoundException();
		
		
		
	}
	
	//This is to get candidates by their id
	@GetMapping("/candidates/{id}")
	//@RequestMapping(name = "/candidates/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCandidateById(@PathVariable int id) {
		if(candidateService.retriveCandidateById(id).isPresent()) {
			return new ResponseEntity<>(candidateService.retriveCandidateById(id), HttpStatus.OK);}
			else throw new CandidateNotFoundException();
			
		
		
		
		
	}
	
	//This is update candidates data by their name
	@PutMapping("/candidates")
	//@RequestMapping(name = "/candidates", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCandidateBycandidate_name(@RequestBody Candidate candidate, @RequestParam String candidate_name) {
		try {
		return new ResponseEntity<> (candidateService.updateCandidateByName(candidate, candidate_name), HttpStatus.OK);}
		catch (Exception e){
			return new ResponseEntity<>("Try Again!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//This is to update candidates data by their id
	@PutMapping("/candidates/{id}")
	//@RequestMapping(name = "/candidates/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCandidateById(@RequestBody Candidate candidate, @PathVariable int id) {
		try {
		return new ResponseEntity<> (candidateService.updateCandidateById(candidate, id), HttpStatus.OK);}
		catch (Exception e){
			return new ResponseEntity<>("Try Again!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	//This is to delete candidates record by their id
	@DeleteMapping("/candidates/{id}")
	//@RequestMapping(name = "/candidates/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCandidate(@PathVariable int id) {
		try {
		    if(candidateService.deleteCandidate(id) == true) {
		    return new ResponseEntity<>("Deleted Successfully",  HttpStatus.OK);}
		    else {
		    	return new ResponseEntity<>("The record already deleted or not found",  HttpStatus.OK);
		    }
		
		}
		catch (Exception e){
			return new ResponseEntity<>("Try Again!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

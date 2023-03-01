package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CandidateExceptionController {
	
	   @ExceptionHandler(value = CandidateNotFoundException.class)
	   public ResponseEntity<Object> exception(CandidateNotFoundException exception) {
	      return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
	   }

}

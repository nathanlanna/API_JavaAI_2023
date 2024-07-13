package me.nathan.controller.exceptions;

import java.rmi.UnexpectedException;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException businnesException){
		
		
		return new ResponseEntity<>(businnesException.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementFound(NoSuchElementException notFoundException){
		
		return new ResponseEntity<>(notFoundException.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException){
		var message = "unexpected server error, see logs";
		logger.error("", unexpectedException);
		return new ResponseEntity<String>(message ,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}

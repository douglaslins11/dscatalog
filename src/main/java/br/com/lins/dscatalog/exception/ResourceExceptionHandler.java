package br.com.lins.dscatalog.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound (ResourceNotFoundException e, HttpServletRequest request){
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(),
														httpStatus.value(),
														"Resource not found",
														e.getMessage(),
														request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(standardError);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseException (DatabaseException e, HttpServletRequest request){
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError(Instant.now(),
														httpStatus.value(),
														"Database exception",
														e.getMessage(),
														request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(standardError);
	}
}
package br.com.lins.dscatalog.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> entityNotFound (EntityNotFoundException e, HttpServletRequest request){
		return ResponseEntity.notFound().build();
	}
}

package com.hrworkforce.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	
	@ExceptionHandler(ResourceAlreadyExistException.class)
	public ResponseEntity<String> handleResourceAlreadyExistException(ResourceAlreadyExistException ex)
	{
		return new ResponseEntity<String> (ex.getMessage(),HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex)
	{
		return new ResponseEntity<String> (ex.getMessage(),HttpStatus.ALREADY_REPORTED);
	}
	
	
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public HashMap<String, Object> handleInvalidMethodArgumentException(MethodArgumentNotValidException ex)
//	{
//		HashMap<String, Object> hmap = new HashMap<>();
//		BindingResult bindingResult = ex.getBindingResult();
//		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//		for (FieldError fieldError : fieldErrors) 
//		{
//			hmap.put(fieldError.getField(), fieldError.getDefaultMessage());
//		}
//		return hmap;
//		
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)    //Prepare This
	public HashMap<String, Object> handleInvalidMethArgsExc(MethodArgumentNotValidException ex)
	{
		HashMap<String, Object> hmap=new HashMap<>();
		hmap.put("Time", new Date());
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) 
		{
			hmap.put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		return hmap;
		
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ErrorResponce handleInvalidMethArgsExc2(MethodArgumentNotValidException ex)
//	{
//		ErrorResponce errorResponce=new ErrorResponce();
//		
//		
//		BindingResult bindingResult = ex.getBindingResult();
//		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//		for (FieldError fieldError : fieldErrors) 
//		{
//			errorResponce.setTimeStamp(new Date());
//			errorResponce.setFieldName(fieldError.getField());
//			errorResponce.setFieldMessage(fieldError.getDefaultMessage());
//			errorResponce.setStatus(fieldError.getCode());
//			
//		}
//		return errorResponce;
		
//	}
	
	
	
	
	
		
}

package com.example.BankingWithSecurity.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers,HttpStatus status,WebRequest request)
	{
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError) error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldName,message);
		});
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> handleACcountNotFoundEXception(AccountNotFoundException ex,WebRequest request)
	{
		String message=ex.getMessage();
		return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<Object> handleInsufficientBalanceException(InsufficientBalanceException ex,WebRequest request)
	{
		String message=ex.getMessage();
		return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BeneficiaryAccountNotFoundException.class)
	public ResponseEntity<Object> handleBeneficiaryAccountNotFoundException(BeneficiaryAccountNotFoundException ex,WebRequest request)
	{
		String message=ex.getMessage();
		return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EmailException.class)
	public ResponseEntity<Object> handleEmailException(EmailException ex,WebRequest request)
	{
		String message=ex.getMessage();
		return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(PassportException.class)
	public ResponseEntity<Object> handlePassportException(PassportException ex,WebRequest request)
	{
		String message=ex.getMessage();
		return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
	}
}

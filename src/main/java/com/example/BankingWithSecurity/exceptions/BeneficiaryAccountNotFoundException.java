package com.example.BankingWithSecurity.exceptions;

public class BeneficiaryAccountNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BeneficiaryAccountNotFoundException(String message)
	{
		super(message);
	}

}

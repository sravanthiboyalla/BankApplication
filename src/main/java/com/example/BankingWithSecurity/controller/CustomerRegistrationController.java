package com.example.BankingWithSecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingWithSecurity.dto.AccountDto;
import com.example.BankingWithSecurity.model.Customer;
import com.example.BankingWithSecurity.service.CustomerRegistrationService;



@RestController
@RequestMapping("/customer")
public class CustomerRegistrationController {
	@Autowired
	CustomerRegistrationService customerRegistrationService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<AccountDto> addCustomer(@Valid @RequestBody Customer customer )
	{
		System.out.println("yes");
		return new ResponseEntity<AccountDto>(customerRegistrationService.addCustomer(customer),HttpStatus.OK);
	}

}

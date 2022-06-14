package com.example.BankingWithSecurity.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingWithSecurity.model.Beneficiary;
import com.example.BankingWithSecurity.service.BeneficiaryService;



@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {
	@Autowired
	BeneficiaryService beneficiaryService;
	@PostMapping("/addBeneficiary")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody Beneficiary beneficiary )
	{
		return new ResponseEntity<String>(beneficiaryService.addBeneficiary(beneficiary),HttpStatus.OK);
	}

}

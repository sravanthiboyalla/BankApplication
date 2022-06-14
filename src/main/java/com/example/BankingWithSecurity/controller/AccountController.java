package com.example.BankingWithSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.BankingWithSecurity.model.Account;
import com.example.BankingWithSecurity.service.AccountService;




@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService accountService;
	@GetMapping("/{accountNumber}")
	public ResponseEntity<Account> getStudentById(@PathVariable String accountNumber)
	{
		return new ResponseEntity<Account>(accountService.getAccounsByAccountNumber(accountNumber),HttpStatus.OK);
	}

}

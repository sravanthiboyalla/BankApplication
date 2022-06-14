package com.example.BankingWithSecurity.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingWithSecurity.model.Transaction;
import com.example.BankingWithSecurity.service.TransactionService;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	@PostMapping("/initiateTransaction")
	public ResponseEntity<String> transfer(@RequestBody Transaction transaction )
	{
		System.out.println(transaction.getAmount());
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");

	      Date date = new Date();
	      System.out.println(dateFormat.format(date));
	      transaction.setDate(date);
	      
		return new ResponseEntity<String>(transactionService.createTransaction(transaction),HttpStatus.OK);
	}
	@GetMapping("/transactionHistory/{fromDate}/{toDate}")
	public ResponseEntity<List<Transaction>> getTransactions(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate)
	{
		System.out.println("yes");
		return new ResponseEntity<List<Transaction>>(transactionService.getTransactions(fromDate,toDate),HttpStatus.OK);
	}
}
